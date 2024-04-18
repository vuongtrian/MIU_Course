package edu.miu.cs489.dental_surgeries_appointment.dto.patient;

import edu.miu.cs489.dental_surgeries_appointment.dto.address.AddressResponse;
import edu.miu.cs489.dental_surgeries_appointment.dto.appointment.AppointmentResponse;

import java.time.LocalDate;
import java.util.List;

public record PatientResponse(
        Long patientId,
        String firstName,
        String lastName,
        String email,
        String phone,
        LocalDate birthDate,
        AddressResponse address,
        List<AppointmentResponse> appointments
) {
}
