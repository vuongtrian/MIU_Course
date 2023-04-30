package miu.edu.CarRental.domain;

import java.util.ArrayList;
import java.util.Collection;

public class CarList {
    private Collection<Car> cars = new ArrayList<>();

    public CarList() {
    }

    public CarList(Collection<Car> cars) {
        this.cars = cars;
    }

    public Collection<Car> getCars() {
        return cars;
    }

    public void setCars(Collection<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "CarList{" +
                "cars=" + cars +
                '}';
    }
}
