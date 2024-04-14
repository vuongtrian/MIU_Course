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
public class RoomRequestDTO {

    @NotBlank(message = "Room number should NOT be NULL or EMPTY")
    private Integer roomNumber;
    @NotNull(message = "Room detail should NOT be NULL")
    private RoomDetailRequestDTO roomDetail;

}
