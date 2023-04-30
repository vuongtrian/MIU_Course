package miu.edu.CarRental.service;

import miu.edu.CarRental.domain.Rental;
import miu.edu.CarRental.intergration.rest.CarFleetGateway;
import miu.edu.CarRental.repository.IRentalRepository;
import miu.edu.CarRental.service.dto.CustomerDTO;
import miu.edu.CarRental.service.dto.RentalAdapter;
import miu.edu.CarRental.service.dto.RentalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RentalService implements IRentalService {

    @Autowired
    private CarFleetGateway carFleetGateway;

    @Autowired
    private IRentalRepository rentalRepository;

    @Override
    public List<RentalDTO> getAllRentByCustomer(long customerId) {
        List<Rental> rentals = rentalRepository.findByCustomerCustomerNumber(customerId);
        return RentalAdapter.getAllRentalDto(rentals);
    }

    @Override
    public RentalDTO reservedCar(CustomerDTO customer, String licensePlate,Date fromDate, Date toDate, String location, double amount) {
        RentalDTO rentalDTO = new RentalDTO();

        rentalDTO.setCustomerDto(customer);
        rentalDTO.setLicensePlate(licensePlate);
        rentalDTO.setFromDate(fromDate);
        rentalDTO.setToDate(toDate);
        rentalDTO.setLocation(location);
        rentalDTO.setState("reserved");
        rentalDTO.setPaymentAmount(amount);
        rentalRepository.save(RentalAdapter.getRentalFromRentalDto(rentalDTO));
        return rentalDTO;
    }

    @Override
    public RentalDTO updateRental(RentalDTO updatedRentalDTO) {
        rentalRepository.save(RentalAdapter.getRentalFromRentalDto(updatedRentalDTO));
        return updatedRentalDTO;
    }
}
