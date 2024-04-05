package cs489.miu.edu.hotel_reservation_service.entity.dto;

import cs489.miu.edu.hotel_reservation_service.entity.Address;
import cs489.miu.edu.hotel_reservation_service.entity.CreditCard;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CustomerRequestDTO {
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
    @NotNull(message = "Address should not be null")
    private Address address;
    @NotNull(message = "CreditCard should not be null")
    private CreditCard creditCard;
}
