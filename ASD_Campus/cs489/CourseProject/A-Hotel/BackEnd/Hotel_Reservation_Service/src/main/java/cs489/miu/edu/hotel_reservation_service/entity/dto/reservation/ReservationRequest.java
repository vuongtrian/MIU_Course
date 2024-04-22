package cs489.miu.edu.hotel_reservation_service.entity.dto.reservation;

import cs489.miu.edu.hotel_reservation_service.entity.dto.room.RoomRequest;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ReservationRequest(
        LocalDate startDate,
        LocalDate endDate,
        BigDecimal totalPrice,
        Integer numberOfGuest
) {
}
