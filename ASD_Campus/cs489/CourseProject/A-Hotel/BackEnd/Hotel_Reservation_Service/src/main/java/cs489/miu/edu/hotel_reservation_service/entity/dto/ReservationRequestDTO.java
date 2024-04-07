package cs489.miu.edu.hotel_reservation_service.entity.dto;

import cs489.miu.edu.hotel_reservation_service.entity.Customer;
import cs489.miu.edu.hotel_reservation_service.entity.Room;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ReservationRequestDTO {
    @NotBlank(message = "Start date should NOT be NULL or EMPTY")
    private LocalDate startDate;
    @NotBlank(message = "End date should NOT be NULL or EMPTY")
    private LocalDate endDate;
    @NotNull(message = "Total price cannot be null")
    @Digits(integer = 5, fraction = 2, message = "Total price must have up to 5 digits in total, with up to 2 decimal places")
    private BigDecimal totalPrice;
    @Min(value = 1, message = "Number of guest must be greater than or equal to 1")
    @Max(value = 10, message = "Number of guest must be greater than or equal to 10")
    private Integer numberOfGuest;
    @NotNull(message = "Room should not be null")
    private Room room;
    @NotNull(message = "Customer should not be null")
    private Customer customer;
}
