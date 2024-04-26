package cs489.miu.edu.hotel_reservation_service.entity.dto.userauth;

import cs489.miu.edu.hotel_reservation_service.entity.enumObj.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private Role role;
    private String email;
    private String password;
}
