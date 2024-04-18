package edu.miu.cs489.dental_surgeries_appointment.dto.patient;

import edu.miu.cs489.dental_surgeries_appointment.dto.address.AddressRequest;
import edu.miu.cs489.dental_surgeries_appointment.dto.appointment.AppointmentRequest;

import java.time.LocalDate;
import java.util.List;

public record PatientRequest(
        String firstName,
        String lastName,
        String email,
        String phone,
        LocalDate birthDate,
        AddressRequest address,
        List<AppointmentRequest> appointments
) {

}
