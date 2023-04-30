package miu.edu.CarFleet.repository;

import miu.edu.CarFleet.domain.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICarRepository extends MongoRepository<Car, String> {

    Car findCarByLicensePlate(String licensePlate);

    List<Car> findByBrand(String brandName);

    List<Car> findByType(String type);

    List<Car> findByTypeAndBrand(String type, String brand);

    List<Car> findByTypeAndPrice(String type, double price);

    List<Car> findByBrandAndPrice(String brand, double price);

    List<Car> findByPrice(double price);

    List<Car> findByStatus(String status);

    List<Car> findByTypeAndBrandAndPrice(String type, String brand, double price);

    List<Car> findByTypeAndBrandAndStatus(String type, String brand, String status);
}
