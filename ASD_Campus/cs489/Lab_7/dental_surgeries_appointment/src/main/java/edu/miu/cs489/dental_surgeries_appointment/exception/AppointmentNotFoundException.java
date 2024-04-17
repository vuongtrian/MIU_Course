package edu.miu.cs489.dental_surgeries_appointment.exception;

public class AppointmentNotFoundException extends RuntimeException{
    public AppointmentNotFoundException(String message) {
        super(message);
    }
}
