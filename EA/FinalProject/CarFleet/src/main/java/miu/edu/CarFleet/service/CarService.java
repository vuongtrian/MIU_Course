package miu.edu.CarFleet.service;

import miu.edu.CarFleet.domain.Car;
import miu.edu.CarFleet.repository.ICarRepository;
import miu.edu.CarFleet.service.dto.CarAdapter;
import miu.edu.CarFleet.service.dto.CarDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService implements ICarService{
    @Autowired
    private ICarRepository carRepository;

    Logger logger = LoggerFactory.getLogger(CarService.class);

    public List<CarDTO> getAllCar() {
        List<Car> cars = carRepository.findAll();
        return CarAdapter.getListCarDto(cars);
    }

    public CarDTO getOneCar (String licensePlate) {
        Optional<Car> carOptional = carRepository.findById(licensePlate);
        Car car = new Car();
        if (carOptional.isPresent()) {
            car = carOptional.get();
        } else {
            logger.error("Car with license plate " + licensePlate + " not found.");
            return null;
        }
        return CarAdapter.getCarDtoFromCar(car);
    }

    public CarDTO addCar (CarDTO newCar) {
        Car car = CarAdapter.getCarFromCarDto(newCar);
        if (car != null) {
            carRepository.save(car);
            logger.info("Saved car with license plate " + car.getLicensePlate() + " successfully");
        } else {
            logger.error("Can't save car");
            return null;
        }
        return newCar;
    }

    public void removeCar (String licensePlate) {
        Optional<Car> carOptional = carRepository.findById(licensePlate);
        if (carOptional.isPresent()) {
            carRepository.deleteById(licensePlate);
            logger.info("Deleted car with license plate " + licensePlate);
        } else {
            logger.error("Car with license plate " + licensePlate + " not found.");
        }
    }

//    public List<CarDTO> searchCar (String type, String brand, Double price) {
//        List<Car> searchResult = new ArrayList<>();
//        if (type == null && brand == null && price == null) {
//            logger.error("Can't search car");
//            return null;
//        } else if (type != null && (brand == null && price == null)) {
//            searchResult = carRepository.findByType(type);
//            if(searchResult == null) {
//                logger.error("Can't find list of car by type " + type);
//                return null;
//            }
//        } else if (brand != null && (type == null && price == null)) {
//            searchResult = carRepository.findByBrand(brand);
//            if(searchResult == null) {
//                logger.error("Can't find list of car by brand " + brand);
//                return null;
//            }
//        } else if (price != null && (type == null && brand == null)) {
//            searchResult = carRepository.findByPrice(price.doubleValue());
//            if(searchResult == null) {
//                logger.error("Can't find list of car by price " + price.doubleValue());
//                return null;
//            }
//        } else if ((type != null && brand != null) && price == null) {
//            searchResult = carRepository.findByTypeAndBrand(type, brand);
//            if(searchResult == null) {
//                logger.error("Can't find list of car by type " + type + " and brand " + brand);
//                return null;
//            }
//        } else if ((type != null && price != null) && brand == null) {
//            searchResult = carRepository.findByTypeAndPrice(type, price.doubleValue());
//            if(searchResult == null) {
//                logger.error("Can't find list of car by type " + type + " and price " + price.doubleValue());
//                return null;
//            }
//        } else if ((brand != null && price != null) && type == null) {
//            searchResult = carRepository.findByBrandAndPrice(brand, price.doubleValue());
//            if(searchResult == null) {
//                logger.error("Can't find list of car by brand " + brand + " and price " + price.doubleValue());
//                return null;
//            }
//        }
//        return CarAdapter.getListCarDto(searchResult);
//    }

    public List<CarDTO> searchCar(String type, String brand, Double price) {
        if (type == null && brand == null && price == null) {
            logger.error("Can't search car");
            return null;
        }

        List<Car> searchResult;
        if (type != null && brand != null && price != null) {
            searchResult = carRepository.findByTypeAndBrandAndPrice(type, brand, price);
        } else if (type != null && brand != null) {
            searchResult = carRepository.findByTypeAndBrand(type, brand);
        } else if (type != null && price != null) {
            searchResult = carRepository.findByTypeAndPrice(type, price);
        } else if (brand != null && price != null) {
            searchResult = carRepository.findByBrandAndPrice(brand, price);
        } else if (type != null) {
            searchResult = carRepository.findByType(type);
        } else if (brand != null) {
            searchResult = carRepository.findByBrand(brand);
        } else {
            searchResult = carRepository.findByPrice(price);
        }

        if (searchResult == null || searchResult.isEmpty()) {
            logger.error("No cars found");
            return null;
        }

        return CarAdapter.getListCarDto(searchResult);
    }

    @Override
    public List<CarDTO> getCarStatusByTypeAndBrand(String type, String brand, String status) {
        List<Car> cars = carRepository.findByTypeAndBrandAndStatus(type,brand, status);
        return CarAdapter.getListCarDto(cars);
    }


}
