package edu.miu.cs489.dental_surgeries_appointment.dto.address;

public record AddressResponse(
        Integer addressId,
        String street,
        String city,
        String state,
        String zipCode
) {
}
