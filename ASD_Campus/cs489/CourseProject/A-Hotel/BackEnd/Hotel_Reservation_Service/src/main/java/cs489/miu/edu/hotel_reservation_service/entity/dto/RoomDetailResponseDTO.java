package cs489.miu.edu.hotel_reservation_service.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDetailResponseDTO {
    private String type;
    private BigDecimal price;
    private String bedType;
    private Integer numberOfBeds;
    private String description;
    private List<FileDataResponseDTO> images = new ArrayList<>();
}
