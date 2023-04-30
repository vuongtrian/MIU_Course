package miu.edu.CarRental.service;

import miu.edu.CarRental.service.dto.CustomerDTO;
import miu.edu.CarRental.service.dto.RentalDTO;

import java.util.Date;
import java.util.List;

public interface IRentalService {

    public List<RentalDTO> getAllRentByCustomer (long customerId);

    public RentalDTO reservedCar (CustomerDTO customer, String licensePlate, Date fromDate, Date toDate, String location, double amount);

    public RentalDTO updateRental (RentalDTO updatedRentalDTO);
}
