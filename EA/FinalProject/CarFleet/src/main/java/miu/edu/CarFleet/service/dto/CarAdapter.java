package miu.edu.CarFleet.service.dto;

import miu.edu.CarFleet.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarAdapter {

    public static CarDTO getCarDtoFromCar (Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setLicensePlate(car.getLicensePlate());
        carDTO.setType(car.getType());
        carDTO.setBrand(car.getBrand());
        carDTO.setPrice(car.getPrice());
        carDTO.setStatus(car.getStatus());
        return carDTO;
    }

    public static Car getCarFromCarDto (CarDTO carDTO) {
        Car car = new Car();
        car.setLicensePlate(carDTO.getLicensePlate());
        car.setType(carDTO.getType());
        car.setBrand(carDTO.getBrand());
        car.setPrice(carDTO.getPrice());
        car.setStatus(carDTO.getStatus());
        return car;
    }

    public static List<CarDTO> getListCarDto (List<Car> cars) {
        List<CarDTO> carDTOList = new ArrayList<>();
        for (Car car : cars ) {
            carDTOList.add(getCarDtoFromCar(car));
        }
        return carDTOList;
    }
}
