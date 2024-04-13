package cs489.miu.edu.hotel_reservation_service.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User{
    @Embedded
    private Address address;
    @Embedded
    private CreditCard creditCard;
    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservations = new ArrayList<>();


}
