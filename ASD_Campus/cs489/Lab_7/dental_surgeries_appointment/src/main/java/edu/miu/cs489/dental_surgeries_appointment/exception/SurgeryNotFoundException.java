package edu.miu.cs489.dental_surgeries_appointment.exception;

public class SurgeryNotFoundException extends RuntimeException{
    public SurgeryNotFoundException(String message) {
        super(message);
    }
}
