package miu.edu.CarFleetClient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CarFleetGateway {

    RestTemplate restTemplate = new RestTemplate();
    private String serverUrl = "http://localhost:8080/cars";

    public CarDTO addCar (String licensePlate, String type, String brand, double price) {
        CarDTO newCar = new CarDTO(licensePlate, type, brand, price, "available");
        restTemplate.postForLocation(serverUrl, newCar);
        return newCar;
    }

    public CarDTO getCar (String licensePlate) {
        try {
            CarDTO car = restTemplate.getForObject(serverUrl + "/{licensePlate}", CarDTO.class, licensePlate);
            return car;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public CarDTOList getAllCar () {
        CarDTOList cars = restTemplate.getForObject(serverUrl, CarDTOList.class);
        return cars;
    }

    public void removeCar (String licensePlate) {
        restTemplate.delete(serverUrl+"/{licensePlate}", licensePlate);
    }

    public CarDTO updateCar (CarDTO updatedCar) {
        CarDTO currentCar = getCar(updatedCar.getLicensePlate());
        if (currentCar == null) {
            System.out.println("Failed to update car!");
        } else {
            restTemplate.put(serverUrl+"/{licensePlate}", updatedCar, updatedCar.getLicensePlate());
        }
        return updatedCar;
    }

    public CarDTOList searchCar (String type, String brand, Double price) {
        CarDTOList cars =  restTemplate.getForObject(serverUrl+"/search?type={type}&brand={brand}&price={price}",
                CarDTOList.class,
                type, brand, price);
        if (cars == null) {
            System.out.println("Not available car!");
        }
        return cars;
    }

}
