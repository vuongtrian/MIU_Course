package cs489.miu.edu.hotel_reservation_service.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {
    private String type;
    private String number;
    private LocalDate expirationDate;
}
