package edu.miu.cs489.dental_surgeries_appointment.dto.appointment;

import java.time.LocalDateTime;

public record AppointmentResponse (
        Long appointmentId,
        LocalDateTime dateTime
) {
}
