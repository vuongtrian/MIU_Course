package cs489.miu.edu.hotel_reservation_service.service;

import cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail.RoomDetailRequest;
import cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail.RoomDetailResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IRoomDetailService {
    RoomDetailResponse createRoomDetail(RoomDetailRequest roomDetailRequest);
    RoomDetailResponse updateRoomDetail(Integer roomId,RoomDetailRequest roomDetailRequest);
    void deleteRoomDetailById(Integer roomId);
    RoomDetailResponse getRoomDetailById(Integer roomId);
    List<RoomDetailResponse> getAllRoomDetails();
}
