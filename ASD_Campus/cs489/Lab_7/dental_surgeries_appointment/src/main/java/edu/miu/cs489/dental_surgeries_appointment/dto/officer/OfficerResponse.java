package edu.miu.cs489.dental_surgeries_appointment.dto.officer;

import edu.miu.cs489.dental_surgeries_appointment.model.Role;

public record OfficerResponse(
        Long officerId,
        String username,
        Role role,
        String firstName,
        String lastName,
        String email,
        String phone
) {
}
