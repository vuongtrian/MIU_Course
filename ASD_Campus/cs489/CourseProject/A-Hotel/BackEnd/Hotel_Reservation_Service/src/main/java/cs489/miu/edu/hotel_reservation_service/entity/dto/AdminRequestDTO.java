package cs489.miu.edu.hotel_reservation_service.entity.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AdminRequestDTO {
    @NotBlank(message = "username should NOT be NULL or EMPTY")
    private String username;
    @NotBlank(message = "password should NOT be NULL or EMPTY")
    private String password;
    private Boolean enabled;
    @NotBlank(message = "First name should NOT be NULL or EMPTY")
    private String firstName;
    @NotBlank(message = "Last name should NOT be NULL or EMPTY")
    private String lastName;
    @NotBlank(message = "Phone number should NOT be NULL or EMPTY")
    @Size(min = 1,
            max = 20,
            message = "Phone number must be between 1 and 20 characters")
    private String phoneNumber;
    @NotBlank(message = "Email should NOT be NULL or EMPTY")
    private String email;
    private String region;
}
