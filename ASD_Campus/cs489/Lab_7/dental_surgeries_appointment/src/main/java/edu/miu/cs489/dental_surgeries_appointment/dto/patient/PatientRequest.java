package edu.miu.cs489.dental_surgeries_appointment.dto.patient;

import edu.miu.cs489.dental_surgeries_appointment.dto.appointment.AppointmentRequest;
import edu.miu.cs489.dental_surgeries_appointment.model.Address;

import java.time.LocalDate;
import java.util.List;

public record PatientRequest(
        String firstName,
        String lastName,
        String email,
        String phone,
        LocalDate birthDate,
        Address address,
        List<AppointmentRequest> appointments
) {

}
