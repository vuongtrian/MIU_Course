package miu.edu.CarRental.service;

import miu.edu.CarRental.service.dto.CustomerDTO;
import miu.edu.CarRental.service.dto.RentalDTO;

import java.util.Date;
import java.util.List;

public interface ICustomerService {
    public List<CustomerDTO> getAllCustomer();
    public CustomerDTO getOneCustomer (long customerNumber);
    public CustomerDTO addCustomer (CustomerDTO newCustomer);

    public CustomerDTO updateCustomer(long customerNumber ,CustomerDTO updatedCustomer);
    public void removeCustomer (long customerNumber);
    public List<CustomerDTO> searchCustomer (String name, String email);

//    business
    public RentalDTO reservedCar (String brand, String type, long customer, Date fromDate, Date toDate, String location);

    public List<RentalDTO> rentCar (long customerId);

    public List<RentalDTO> payForRent (long customerId);
}
