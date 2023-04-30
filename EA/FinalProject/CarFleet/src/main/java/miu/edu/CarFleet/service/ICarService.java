package miu.edu.CarFleet.service;

import miu.edu.CarFleet.service.dto.CarDTO;

import java.util.List;

public interface ICarService {
    public List<CarDTO> getAllCar();
    public CarDTO getOneCar (String licensePlate);
    public CarDTO addCar (CarDTO newCar);
    public void removeCar (String licensePlate);
    public List<CarDTO> searchCar (String type, String brand, Double price);

    public List<CarDTO> getCarStatusByTypeAndBrand (String type, String brand, String status);
}
