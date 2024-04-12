package cs489.miu.edu.hotel_reservation_service.entity.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RoomDetailRequestDTO {
    @Size(min = 1,
            max = 20,
            message = "Room type must be between 1 and 20 characters")
    private String type;
    @NotNull(message = "Room price cannot be null")
    @DecimalMin(value = "70", message = "Room price must be greater than or equal to 30")
    @DecimalMax(value = "200", message = "Room price must be lower than or equal to 200")
    @Digits(integer = 5, fraction = 2, message = "Room price must have up to 5 digits in total, with up to 2 decimal places")
    private BigDecimal price;
    @Size(min = 1,
            max = 20,
            message = "Bed type must be between 1 and 20 characters")
    private String bedType;
    @Min(value = 1, message = "Number of beds must be greater than or equal to 1")
    @Max(value = 5, message = "Number of beds must be lower than or equal to 5")
    private Integer numberOfBeds;
    @Size(max = 500,
            message = "Bed type must be smaller than 500 characters")
    private String description;
}
