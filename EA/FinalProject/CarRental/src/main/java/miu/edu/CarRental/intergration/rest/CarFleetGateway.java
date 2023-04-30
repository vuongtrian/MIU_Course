package miu.edu.CarRental.intergration.rest;

import miu.edu.CarRental.domain.Car;
import miu.edu.CarRental.domain.CarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Component
public class CarFleetGateway {

    @Autowired
    private CarFleetProperties carFleetProperties;

    RestTemplate restTemplate = new RestTemplate();
//    private String serverUrl = "http://localhost:8080/cars";

//    http://localhost:8080/cars/check?type=Everest&brand=Ford&status=available
    public CarList findAvailableCarByTypeAndBrand (String type, String brand, String status) {
        CarList cars = restTemplate.getForObject(carFleetProperties.getUrl() +"/check?type={type}&brand={brand}&status={status}",
                CarList.class, type, brand, status);
            return cars;
    }

//    @PutMapping("/cars/{licensePlate}")
//    public ResponseEntity<?> updateCar (
//            @PathVariable String licensePlate,
//            @RequestBody CarDTO car)

//    public CarDTO updateCar (CarDTO updatedCar) {
//        CarDTO currentCar = getCar(updatedCar.getLicensePlate());
//        if (currentCar == null) {
//            System.out.println("Failed to update car!");
//        } else {
//            restTemplate.put(serverUrl+"/{licensePlate}", updatedCar, updatedCar.getLicensePlate());
//        }
//        return updatedCar;
//    }

    public Car updateCarStatus (Car updatedCar) {
        restTemplate.put(carFleetProperties.getUrl()+"/{licensePlate}", updatedCar, updatedCar.getLicensePlate());
        return updatedCar;
    }

    public Car getCar (String licensePlate) {
        Car car = restTemplate.getForObject(carFleetProperties.getUrl()+"/{licensePlate}", Car.class, licensePlate);
        return car;
    }
}
