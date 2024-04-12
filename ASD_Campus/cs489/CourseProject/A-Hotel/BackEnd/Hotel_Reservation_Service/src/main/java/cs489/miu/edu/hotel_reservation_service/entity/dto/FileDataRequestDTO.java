package cs489.miu.edu.hotel_reservation_service.entity.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FileDataRequestDTO {
    @NotBlank(message = "file type should NOT be NULL or EMPTY")
    private String type;
    @NotBlank(message = "file name should NOT be NULL or EMPTY")
    private String name;
    @NotBlank(message = "file path should NOT be NULL or EMPTY")
    private String path;
}
