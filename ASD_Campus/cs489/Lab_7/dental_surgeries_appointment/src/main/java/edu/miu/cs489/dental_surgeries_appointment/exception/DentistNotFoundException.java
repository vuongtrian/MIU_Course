package edu.miu.cs489.dental_surgeries_appointment.exception;

public class DentistNotFoundException extends RuntimeException{
    public DentistNotFoundException(String message) {
        super(message);
    }
}
