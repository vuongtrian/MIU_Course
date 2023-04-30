package miu.edu.CarRental.service;

import miu.edu.CarRental.domain.Car;
import miu.edu.CarRental.domain.CarList;
import miu.edu.CarRental.domain.Customer;
import miu.edu.CarRental.intergration.rest.CarFleetGateway;
import miu.edu.CarRental.repository.ICustomerRepository;
import miu.edu.CarRental.service.dto.CustomerAdapter;
import miu.edu.CarRental.service.dto.CustomerDTO;
import miu.edu.CarRental.service.dto.HistoryDTO;
import miu.edu.CarRental.service.dto.RentalDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private CarFleetGateway carFleetGateway;

    @Autowired
    private IRentalService rentalService;

    @Autowired
    private IHistoryService historyService;

    @Autowired
    private JmsTemplate jmsTemplate;

    Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        return CustomerAdapter.getListCustomerDto(customers);
    }

    @Override
    public CustomerDTO getOneCustomer(long customerNumber) {
        Optional<Customer> customerOptional = customerRepository.findById(customerNumber);
        Customer customer = new Customer();
        if (customerOptional.isPresent()) {
           customer = customerOptional.get();
        } else {
            logger.error("Customer with number " + customerNumber + " not found.");
            return null;
        }
        return CustomerAdapter.getCustomerDtoFromCustomer(customer);
    }

    @Override
    public CustomerDTO addCustomer(CustomerDTO newCustomer) {
        Customer customer = CustomerAdapter.getCustomerFromCustomerDtoWihtoutId(newCustomer);
        if (customer != null) {
            customerRepository.save(customer);
            logger.info("Saved customer with customer number " + customer.getCustomerNumber() + " successfully");
        } else {
            logger.error("Can't save customer");
            return null;
        }
        return CustomerAdapter.getCustomerDtoFromCustomer(customer);
    }

    @Override
    public CustomerDTO updateCustomer(long customerNumber ,CustomerDTO updatedCustomer) {
//        CustomerDTO curCustomer = getOneCustomer(customerNumber);
        Customer curCustomer = customerRepository.findById(customerNumber).orElse(null);
        if (curCustomer == null) {
            return null;
        }
        curCustomer.setName(updatedCustomer.getName());
        curCustomer.setEmail(updatedCustomer.getEmail());
        customerRepository.save(curCustomer);
        return CustomerAdapter.getCustomerDtoFromCustomer(curCustomer);
    }

    @Override
    public void removeCustomer(long customerNumber) {
        Optional<Customer> customerOptional = customerRepository.findById(customerNumber);
        if (customerOptional.isPresent()) {
            customerRepository.deleteById(customerNumber);
            logger.info("Deleted customer with number " + customerNumber);
        } else {
            logger.error("Customer with number " + customerNumber + " not found.");
        }
    }

    @Override
    public List<CustomerDTO> searchCustomer(String name, String email) {
        if (name == null && email == null) {
            logger.error("Can't search customer");
            return null;
        }

        List<Customer> searchResult;
        if (name != null && email != null) {
            searchResult = customerRepository.findByNameAndEmail(name, email);
        } else if (name != null) {
            searchResult = customerRepository.findByName(name);
        } else {
            searchResult = customerRepository.findByEmail(email);
        }

        if (searchResult == null || searchResult.isEmpty()) {
            logger.error("No customer found");
            return null;
        }

        return CustomerAdapter.getListCustomerDto(searchResult);
    }

//    business
    @Override
    public RentalDTO reservedCar(String brand, String type, long customerId, Date fromDate, Date toDate, String location) {
        /*
        * check if any available car
        * if any car is available
        *   => reserve car
        *   => add to history
        *   => update car status in carFleet server
        *   => send Jms message to carFleet server
        * else => log out
        * */
        CarList cars = carFleetGateway.findAvailableCarByTypeAndBrand(type, brand, "available");
        RentalDTO rentalDTO = new RentalDTO();
        if (cars == null) {
            logger.warn("No available car!");
            return null;
        } else {
            Car car = new Car();
            try {
                car = cars.getCars().stream().findFirst().get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }

            String licensePlate = car.getLicensePlate();
            double amount = DateService.countDate(fromDate, toDate) * car.getPrice();
            CustomerDTO customer = getOneCustomer(customerId);
            rentalDTO = rentalService.reservedCar(customer, licensePlate,fromDate, toDate, location, amount);
//            update status for car
            car.setStatus("reserved");
            carFleetGateway.updateCarStatus(car);
//            send message to car fleet server
            jmsTemplate.convertAndSend("ReservedCar", "Customer just reserved a car with license plate " + licensePlate);

//            add to history
            addToHistory(customerId,licensePlate,brand,type,fromDate,toDate, "reserve");
        }
        return rentalDTO;
    }

    @Override
    public List<RentalDTO> rentCar(long customerId) {
        /*
        * - Get all rental of this customer
        * - update status to from "reserved" to "rent" for Rental
        * - update status for this car from "reserved" to "rent" in CarFleet server
        * - add to history
        * */
        List<RentalDTO> rentalDTOList = rentalService.getAllRentByCustomer(customerId);
        for (RentalDTO rentalDTO : rentalDTOList) {
            rentalDTO.setState("rent");
            rentalService.updateRental(rentalDTO);
            Car car = carFleetGateway.getCar(rentalDTO.getLicensePlate());
            car.setStatus("rent");
            carFleetGateway.updateCarStatus(car);

//            add to history
            addToHistory(customerId, car.getLicensePlate(),
                    car.getBrand(), car.getType(), rentalDTO.getFromDate(),
                    rentalDTO.getToDate(), "rent");
        }


        return rentalDTOList;
    }

    @Override
    public List<RentalDTO> payForRent(long customerId) {
        /*
        * - Get all rental of this customer
        * - update status to from "reserved" to "rent" for Rental
        * - update status for this car from "rent" to "available" in CarFleet server
        * - add to history
        * */
        List<RentalDTO> rentalDTOList = rentalService.getAllRentByCustomer(customerId);
        for (RentalDTO rentalDTO : rentalDTOList) {
            rentalDTO.setState("paid");
            rentalDTO.setPaymentType("creditcard");
            rentalService.updateRental(rentalDTO);
            Car car = carFleetGateway.getCar(rentalDTO.getLicensePlate());
            car.setStatus("available");
            carFleetGateway.updateCarStatus(car);

//            add to history
            addToHistory(customerId, car.getLicensePlate(), car.getBrand(),
                    car.getType(), rentalDTO.getFromDate(), rentalDTO.getToDate(), "paid");
        }
        return rentalDTOList;
    }


    public void addToHistory(long customerId, String licensePlate, String brand, String type, Date fromDate, Date toDate, String state) {
        HistoryDTO historyDTO = new HistoryDTO();
        historyDTO.setCustomerNumber(customerId);
        historyDTO.setLicensePlate(licensePlate);
        historyDTO.setBrand(brand);
        historyDTO.setType(type);
        historyDTO.setFromDate(fromDate);
        historyDTO.setToDate(toDate);
        historyDTO.setState(state);
        historyService.addHistory(historyDTO);
    }
}
