package cs489.miu.edu.hotel_reservation_service.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import cs489.miu.edu.hotel_reservation_service.entity.Address;
import cs489.miu.edu.hotel_reservation_service.entity.CreditCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponseDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Address address;
    private CreditCard creditCard;
}
