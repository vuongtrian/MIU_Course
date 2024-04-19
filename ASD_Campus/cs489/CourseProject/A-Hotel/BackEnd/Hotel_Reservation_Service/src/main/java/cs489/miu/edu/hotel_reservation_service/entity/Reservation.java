package cs489.miu.edu.hotel_reservation_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reservationNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal totalPrice;
    private Integer numberOfGuest;
    @ManyToOne
    @JoinColumn(name = "roomNumber")
    private Room room;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    public Reservation(LocalDate startDate, LocalDate endDate, BigDecimal totalPrice, Integer numberOfGuest) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
        this.numberOfGuest = numberOfGuest;
    }
}
