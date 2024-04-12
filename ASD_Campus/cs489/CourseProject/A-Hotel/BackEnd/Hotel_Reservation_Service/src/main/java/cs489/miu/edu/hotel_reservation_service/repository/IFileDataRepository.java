package cs489.miu.edu.hotel_reservation_service.repository;

import cs489.miu.edu.hotel_reservation_service.entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFileDataRepository extends JpaRepository<FileData, Integer> {
}
