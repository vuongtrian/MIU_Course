package cs489.miu.edu.hotel_reservation_service.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileDataResponseDTO {
    private Integer id;
    private String type;
    private String name;
    private String path;
}
