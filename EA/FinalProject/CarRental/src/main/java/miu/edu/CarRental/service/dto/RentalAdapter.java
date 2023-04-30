package miu.edu.CarRental.service.dto;

import miu.edu.CarRental.domain.Rental;

import java.util.ArrayList;
import java.util.List;

public class RentalAdapter {

    public static Rental getRentalFromRentalDto (RentalDTO rentalDTO) {
        Rental rental = new Rental();
        rental.setId(rentalDTO.getId());
        rental.setLicensePlate(rentalDTO.getLicensePlate());
        rental.setLocation(rentalDTO.getLocation());
        rental.setFromDate(rentalDTO.getFromDate());
        rental.setToDate(rentalDTO.getToDate());
        rental.setState(rentalDTO.getState());
        rental.setCustomer(CustomerAdapter.getCustomerFromCustomerDto(rentalDTO.getCustomerDto()));
        rental.setPaymentType(rentalDTO.getPaymentType());
        rental.setPaymentAmount(rentalDTO.getPaymentAmount());
        return rental;
    }

    public static RentalDTO getRentalDtoFromRental (Rental rental) {
        RentalDTO rentalDTO = new RentalDTO();
        rentalDTO.setId(rental.getId());
        rentalDTO.setLicensePlate(rental.getLicensePlate());
        rentalDTO.setLocation(rental.getLocation());
        rentalDTO.setFromDate(rental.getFromDate());
        rentalDTO.setToDate(rental.getToDate());
        rentalDTO.setState(rental.getState());
        rentalDTO.setCustomerDto(CustomerAdapter.getCustomerDtoFromCustomer(rental.getCustomer()));
        rentalDTO.setPaymentType(rental.getPaymentType());
        rentalDTO.setPaymentAmount(rental.getPaymentAmount());
        return rentalDTO;
    }

    public static List<RentalDTO> getAllRentalDto (List<Rental> rentals) {
        List<RentalDTO> rentalDTOList = new ArrayList<>();
        for (Rental rental : rentals) {
            rentalDTOList.add(getRentalDtoFromRental(rental));
        }
        return rentalDTOList;
    }
}
