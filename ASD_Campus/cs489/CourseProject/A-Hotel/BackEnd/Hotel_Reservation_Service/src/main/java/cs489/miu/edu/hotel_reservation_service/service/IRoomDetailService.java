package cs489.miu.edu.hotel_reservation_service.service;

import cs489.miu.edu.hotel_reservation_service.entity.dto.RoomDetailRequestDTO;
import cs489.miu.edu.hotel_reservation_service.entity.dto.RoomDetailResponseDTO;

import java.util.List;

public interface IRoomDetailService {
    RoomDetailResponseDTO createRoomDetail(RoomDetailRequestDTO roomDetailRequestDTO);
    RoomDetailResponseDTO updateRoomDetail(Integer roomId,RoomDetailRequestDTO roomDetailRequestDTO);
    void deleteRoomDetail(Integer roomId);
    RoomDetailResponseDTO getRoomDetailById(Integer roomId);
    List<RoomDetailResponseDTO> getAllRoomDetails();
}
