package cs489.miu.edu.hotel_reservation_service.repository;

import cs489.miu.edu.hotel_reservation_service.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomRepository extends JpaRepository<Room, Integer> {
}
