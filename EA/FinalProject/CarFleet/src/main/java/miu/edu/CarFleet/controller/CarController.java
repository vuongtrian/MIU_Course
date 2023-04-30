package miu.edu.CarFleet.controller;

import miu.edu.CarFleet.service.ICarService;
import miu.edu.CarFleet.service.dto.CarDTO;
import miu.edu.CarFleet.service.dto.CarDTOList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private ICarService carService;

//    get one car
    @GetMapping("/cars/{licensePlate}")
    public ResponseEntity<?> getCar (@PathVariable String licensePlate) {
        CarDTO car = carService.getOneCar(licensePlate);
        if (car == null) {
            return new ResponseEntity<String>(
                    "Car with license plate " + licensePlate + " is not available",
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CarDTO>(car, HttpStatus.OK);
    }

//    get all car
    @GetMapping("/cars")
    public ResponseEntity<?> getAllCar () {
        CarDTOList cars = new CarDTOList(carService.getAllCar());
        return new ResponseEntity<CarDTOList>(cars, HttpStatus.OK);
    }

//    add new car
    @PostMapping("/cars")
    public ResponseEntity<?> addCar (@RequestBody CarDTO newCar) {
        carService.addCar(newCar);
        return new ResponseEntity<CarDTO>(newCar, HttpStatus.CREATED);
    }

//    remove a car
    @DeleteMapping("/cars/{licensePlate}")
    public ResponseEntity<?> removeCar (@PathVariable String licensePlate) {
        CarDTO car = carService.getOneCar(licensePlate);
        if (car == null) {
            return new ResponseEntity<String>(
                    "Car with license plate " + licensePlate + " is not available",
                    HttpStatus.NOT_FOUND);
        }
        carService.removeCar(licensePlate);
        return new ResponseEntity<String>(
                "Remove car with license plate " + licensePlate + " successfully",
                HttpStatus.NO_CONTENT);
    }

//    update a car
    @PutMapping("/cars/{licensePlate}")
    public ResponseEntity<?> updateCar (
            @PathVariable String licensePlate,
            @RequestBody CarDTO car) {
        CarDTO curCar = carService.getOneCar(licensePlate);
        if (car == null) {
            return new ResponseEntity<String>(
                    "Car with license plate " + licensePlate + " is not available",
                    HttpStatus.NOT_FOUND);
        }
        curCar.setType(car.getType());
        curCar.setBrand(car.getBrand());
        curCar.setPrice(car.getPrice());
        curCar.setStatus(car.getStatus());
        carService.addCar(curCar);
        return new ResponseEntity<CarDTO>(curCar, HttpStatus.OK);
    }

//    search car
    @GetMapping("/cars/search")
    public ResponseEntity<?> searchCar (
            @RequestParam(value = "type", required = false, defaultValue = "") String type,
            @RequestParam(value = "brand", required = false, defaultValue = "") String brand,
            @RequestParam(value = "price", required = false, defaultValue = "0") Double price) {

        CarDTOList cars = new CarDTOList();
        cars.setCars(carService.searchCar(type.equals("") ? null : type, brand.equals("") ? null : brand, price == 0 ? null : price));
        if (cars == null) {
            return new ResponseEntity<String>(
                    "Not found",
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CarDTOList>(cars, HttpStatus.OK);
    }

//    get all available car
    @GetMapping("/cars/check")
    public ResponseEntity<?> getAllAvailableCarByTypeAndBrand (
            @RequestParam (value = "type") String type,
            @RequestParam (value = "brand") String brand,
            @RequestParam (value = "status") String status) {
        CarDTOList cars = new CarDTOList();
        cars.setCars(carService.getCarStatusByTypeAndBrand(type,brand, status));
        if (cars == null) {
            return new ResponseEntity<String>(
                    "Not found",
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CarDTOList>(cars, HttpStatus.OK);
    }

}
