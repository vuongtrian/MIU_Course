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
public class Surgery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long surgeryId;
    private String surgeryName;
    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "surgery")
    private List<Appointment> appointments;
}
