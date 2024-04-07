package cs489.miu.edu.hotel_reservation_service.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import cs489.miu.edu.hotel_reservation_service.entity.Customer;
import cs489.miu.edu.hotel_reservation_service.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationResponseDTO {
    private Integer reservationNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal totalPrice;
    private Integer numberOfGuest;
    private Room room;
    private Customer customer;
}
