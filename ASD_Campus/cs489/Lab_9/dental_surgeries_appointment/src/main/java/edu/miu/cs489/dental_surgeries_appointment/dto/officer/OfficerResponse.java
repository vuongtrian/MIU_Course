package edu.miu.cs489.dental_surgeries_appointment.dto.officer;

import edu.miu.cs489.dental_surgeries_appointment.model.OfficerRole;

public record OfficerResponse(
        Long officerId,
        String username,
        OfficerRole role,
        String firstName,
        String lastName,
        String email,
        String phone
) {
}
