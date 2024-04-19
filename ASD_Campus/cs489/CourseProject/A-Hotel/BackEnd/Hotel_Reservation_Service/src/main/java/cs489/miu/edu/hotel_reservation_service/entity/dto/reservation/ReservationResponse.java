package cs489.miu.edu.hotel_reservation_service.entity.dto.reservation;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ReservationResponse(
        Integer reservationNumber,
        LocalDate startDate,
        LocalDate endDate,
        BigDecimal totalPrice,
        Integer numberOfGuest
) {
}
