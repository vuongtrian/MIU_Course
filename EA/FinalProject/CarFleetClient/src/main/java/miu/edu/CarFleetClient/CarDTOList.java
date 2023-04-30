package miu.edu.CarFleetClient;

import java.util.ArrayList;
import java.util.Collection;

public class CarDTOList {
    private Collection<CarDTO> cars = new ArrayList<>();

    public CarDTOList() {
    }

    public CarDTOList(Collection<CarDTO> cars) {
        this.cars = cars;
    }

    public Collection<CarDTO> getCars() {
        return cars;
    }

    public void setCars(Collection<CarDTO> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "CarDTOList{" +
                "cars=" + cars +
                '}';
    }
}
