package cs489.miu.edu.hotel_reservation_service.entity.dto.room;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs489.miu.edu.hotel_reservation_service.entity.Room;
import cs489.miu.edu.hotel_reservation_service.entity.dto.reservation.ReservationValueMapper;
import cs489.miu.edu.hotel_reservation_service.entity.dto.roomDetail.RoomDetailValueMapper;

import java.util.ArrayList;

public class RoomValueMapper {
    public static Room convertToEntity(RoomRequest roomRequest) {
        return new Room(
                roomRequest.roomNumber(),
                RoomDetailValueMapper.convertToEntity(roomRequest.roomDetailRequest())
        );
    }

    public static RoomResponse convertToDto(Room room) {
        return new RoomResponse(
                room.getRoomNumber(),
                RoomDetailValueMapper.convertToDto(room.getRoomDetail())
        );
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
