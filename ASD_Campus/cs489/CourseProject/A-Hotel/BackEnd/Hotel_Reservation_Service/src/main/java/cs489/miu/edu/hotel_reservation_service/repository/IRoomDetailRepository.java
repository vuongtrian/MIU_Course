package cs489.miu.edu.hotel_reservation_service.repository;

import cs489.miu.edu.hotel_reservation_service.entity.RoomDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomDetailRepository extends JpaRepository<RoomDetail, Integer> {
}
