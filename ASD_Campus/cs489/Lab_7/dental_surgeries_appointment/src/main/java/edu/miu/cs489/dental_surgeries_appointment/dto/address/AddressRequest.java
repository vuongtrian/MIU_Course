package edu.miu.cs489.dental_surgeries_appointment.dto.address;

public record AddressRequest (
        String street,
        String city,
        String state,
        String zipCode
) {

}
