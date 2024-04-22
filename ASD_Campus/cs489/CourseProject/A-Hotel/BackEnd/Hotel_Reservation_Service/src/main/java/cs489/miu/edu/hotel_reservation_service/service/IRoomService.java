package cs489.miu.edu.hotel_reservation_service.service;

import cs489.miu.edu.hotel_reservation_service.entity.dto.room.RoomRequest;
import cs489.miu.edu.hotel_reservation_service.entity.dto.room.RoomResponse;

import java.util.List;

public interface IRoomService {
    RoomResponse createRoom(Integer roomDetailId, Integer roomNumber);
    RoomResponse updateRoom(Integer roomDetailId, Integer roomNumber);
    void deleteRoomById(Integer roomId);
    RoomResponse getRoomById(Integer roomId);
    List<RoomResponse> getAllRooms();
}
