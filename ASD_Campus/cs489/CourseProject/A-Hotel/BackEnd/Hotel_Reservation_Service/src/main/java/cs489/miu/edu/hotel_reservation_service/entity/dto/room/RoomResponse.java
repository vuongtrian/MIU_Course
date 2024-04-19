package cs489.miu.edu.hotel_reservation_service.entity.dto.room;

import cs489.miu.edu.hotel_reservation_service.entity.dto.reservation.ReservationResponse;

import java.util.List;

public record RoomResponse(
        Integer roomNumber,
        List<ReservationResponse> reservations
) {
}
