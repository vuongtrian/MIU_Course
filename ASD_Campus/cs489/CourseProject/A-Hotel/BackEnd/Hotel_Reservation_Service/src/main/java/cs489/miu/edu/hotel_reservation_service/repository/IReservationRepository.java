package cs489.miu.edu.hotel_reservation_service.repository;

import cs489.miu.edu.hotel_reservation_service.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReservationRepository extends JpaRepository<Reservation, Integer> {
}
