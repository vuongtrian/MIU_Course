package edu.miu.cs489.dental_surgeries_appointment.exception;

public class OfficerNotFoundException extends RuntimeException {
    public OfficerNotFoundException(String message) {
        super(message);
    }
}
