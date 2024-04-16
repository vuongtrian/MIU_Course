package edu.miu.cs489.dental_surgeries_appointment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
