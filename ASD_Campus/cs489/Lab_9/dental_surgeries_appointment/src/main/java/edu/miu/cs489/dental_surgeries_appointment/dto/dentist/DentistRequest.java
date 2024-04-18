package edu.miu.cs489.dental_surgeries_appointment.dto.dentist;

import edu.miu.cs489.dental_surgeries_appointment.dto.appointment.AppointmentRequest;

import java.util.List;

public record DentistRequest(
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String specialization,
        List<AppointmentRequest> appointments
) {
}
