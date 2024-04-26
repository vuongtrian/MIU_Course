package cs489.miu.edu.hotel_reservation_service.repository;

import cs489.miu.edu.hotel_reservation_service.entity.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IOfficerRepository extends JpaRepository<Officer, Integer> {
    Optional<Officer> findByEmail(String email);
}
