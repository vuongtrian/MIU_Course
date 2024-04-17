package edu.miu.cs489.dental_surgeries_appointment.dto.surgery;

import edu.miu.cs489.dental_surgeries_appointment.dto.address.AddressRequest;
import edu.miu.cs489.dental_surgeries_appointment.dto.appointment.AppointmentRequest;

import java.util.List;

public record SurgeryRequest(
        String surgeryName,
        AddressRequest address,
        List<AppointmentRequest> appointments
) {
}
