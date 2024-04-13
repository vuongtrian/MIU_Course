package cs489.miu.edu.hotel_reservation_service.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdminResponseDTO {
    private Integer id;
    private String username;
    private Boolean enable;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String region;
}
