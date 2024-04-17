package edu.miu.cs489.dental_surgeries_appointment.dto.dentist;

import edu.miu.cs489.dental_surgeries_appointment.dto.appointment.AppointmentResponse;

import java.util.List;

public record DentistResponse(
        Long dentistId,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String specialization,
        List<AppointmentResponse> appointments
) {
}
