package cs489.miu.edu.hotel_reservation_service.entity.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs489.miu.edu.hotel_reservation_service.entity.Room;
import cs489.miu.edu.hotel_reservation_service.entity.dto.RoomRequestDTO;
import cs489.miu.edu.hotel_reservation_service.entity.dto.RoomResponseDTO;

public class RoomValueMapper {
    public static Room convertToEntity(RoomRequestDTO roomRequestDTO) {
        Room room = new Room();
        room.setRoomNumber(roomRequestDTO.getRoomNumber());
        room.setRoomDetail(RoomDetailValueMapper.convertToEntity(roomRequestDTO.getRoomDetail()));
        return room;
    }

    public static RoomResponseDTO convertToDTO(Room room) {
        RoomResponseDTO roomResponseDTO = new RoomResponseDTO();
        roomResponseDTO.setRoomNumber(room.getRoomNumber());
        roomResponseDTO.setRoomDetail(RoomDetailValueMapper.convertToDTO(room.getRoomDetail()));
        return roomResponseDTO;
    }

    public static String jsonAsString(Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
