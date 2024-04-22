package cs489.miu.edu.hotel_reservation_service.entity.dto.reservation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs489.miu.edu.hotel_reservation_service.entity.Reservation;
import cs489.miu.edu.hotel_reservation_service.entity.dto.room.RoomValueMapper;

public class ReservationValueMapper {
    public static Reservation convertToEntity(ReservationRequest reservationRequest) {
        return new Reservation(
                reservationRequest.startDate(),
                reservationRequest.endDate(),
                reservationRequest.totalPrice(),
                reservationRequest.numberOfGuest()
        );
    }

    public static ReservationResponse convertToDto(Reservation reservation) {
        return new ReservationResponse(
                reservation.getReservationNumber(),
                reservation.getStartDate(),
                reservation.getEndDate(),
                reservation.getTotalPrice(),
                reservation.getNumberOfGuest(),
                RoomValueMapper.convertToDto(reservation.getRoom())
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
