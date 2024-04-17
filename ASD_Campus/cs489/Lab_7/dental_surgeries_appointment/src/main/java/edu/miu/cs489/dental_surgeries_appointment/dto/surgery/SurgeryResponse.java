package edu.miu.cs489.dental_surgeries_appointment.dto.surgery;

import edu.miu.cs489.dental_surgeries_appointment.dto.address.AddressResponse;
import edu.miu.cs489.dental_surgeries_appointment.dto.appointment.AppointmentResponse;

import java.util.List;

public record SurgeryResponse(
        Long surgeryId,
        String surgeryName,
        AddressResponse address,
        List<AppointmentResponse> appointments
) {
}
