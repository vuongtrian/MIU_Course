package cs489.miu.edu.hotel_reservation_service.entity.dto.room;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs489.miu.edu.hotel_reservation_service.entity.Room;
import cs489.miu.edu.hotel_reservation_service.entity.dto.reservation.ReservationValueMapper;

import java.util.ArrayList;

public class RoomValueMapper {
    public static Room convertToEntity(RoomRequest roomRequest) {
        return new Room(
                roomRequest.roomNumber(),
                roomRequest.reservations().isEmpty() ?
                        new ArrayList<>() :
                        roomRequest.reservations().stream().map(ReservationValueMapper::convertToEntity).toList()
        );
    }

    public static RoomResponse convertToDto(Room room) {
        return new RoomResponse(
                room.getRoomNumber(),
                room.getReservations().isEmpty() ?
                        new ArrayList<>() :
                        room.getReservations().stream().map(ReservationValueMapper::convertToDto).toList()
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
