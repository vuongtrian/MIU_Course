package miu.edu.CarRental.service.dto;

import java.util.ArrayList;
import java.util.Collection;

public class RentalDTOList {
    Collection<RentalDTO> rentalDTOList = new ArrayList<>();

    public RentalDTOList() {
    }

    public RentalDTOList(Collection<RentalDTO> rentalDTOList) {
        this.rentalDTOList = rentalDTOList;
    }

    public Collection<RentalDTO> getRentalDTOList() {
        return rentalDTOList;
    }

    public void setRentalDTOList(Collection<RentalDTO> rentalDTOList) {
        this.rentalDTOList = rentalDTOList;
    }

    @Override
    public String toString() {
        return "RentalDTOList{" +
                "rentalDTOList=" + rentalDTOList +
                '}';
    }
}
