package cs489.miu.edu.hotel_reservation_service.repository;

import cs489.miu.edu.hotel_reservation_service.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}
