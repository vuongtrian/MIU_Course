package edu.miu.cs489.dental_surgeries_appointment.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dentistId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String specialization;

    @OneToMany(mappedBy = "dentist")
    private List<Appointment> appointments;

    public Dentist(String firstName, String lastName, String email, String phoneNumber, String specialization, List<Appointment> appointments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.specialization = specialization;
        this.appointments = appointments;
    }
}
