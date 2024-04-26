package cs489.miu.edu.hotel_reservation_service.repository;

import cs489.miu.edu.hotel_reservation_service.entity.FileData;
import cs489.miu.edu.hotel_reservation_service.entity.RoomDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IFileDataRepository extends JpaRepository<FileData, Integer> {
    List<FileData> findByRoomDetail(RoomDetail roomDetail);
    @Query("SELECT fd FROM FileData fd WHERE fd.roomDetail.id = ?1")
    FileData findByRoomDetailId(Integer roomDetailId);
}
