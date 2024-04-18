package edu.miu.cs489.dental_surgeries_appointment.dto.officer;

import edu.miu.cs489.dental_surgeries_appointment.model.OfficerRole;

public record OfficerRequest(
        String username,
        String password,
        OfficerRole role,
        String firstName,
        String lastName,
        String email,
        String phone
) {
}
