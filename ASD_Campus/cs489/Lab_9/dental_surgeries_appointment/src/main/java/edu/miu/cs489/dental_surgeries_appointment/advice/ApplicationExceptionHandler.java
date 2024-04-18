package edu.miu.cs489.dental_surgeries_appointment.advice;

import edu.miu.cs489.dental_surgeries_appointment.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(AddressNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleAddressNotFoundException(AddressNotFoundException ex) {
        Map<String, String> errorMessageMap = new HashMap<>();
        errorMessageMap.put("message", ex.getMessage());
        return errorMessageMap;
    }

    @ExceptionHandler(AppointmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleAppointmentNotFoundException(AppointmentNotFoundException ex) {
        Map<String, String> errorMessageMap = new HashMap<>();
        errorMessageMap.put("message", ex.getMessage());
        return errorMessageMap;
    }

    @ExceptionHandler(DentistNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleDentistNotFoundException(DentistNotFoundException ex) {
        Map<String, String> errorMessageMap = new HashMap<>();
        errorMessageMap.put("message", ex.getMessage());
        return errorMessageMap;
    }

    @ExceptionHandler(OfficerNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleOfficerNotFoundException(OfficerNotFoundException ex) {
        Map<String, String> errorMessageMap = new HashMap<>();
        errorMessageMap.put("message", ex.getMessage());
        return errorMessageMap;
    }

    @ExceptionHandler(PatientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handlePatientNotFoundException(PatientNotFoundException ex) {
        Map<String, String> errorMessageMap = new HashMap<>();
        errorMessageMap.put("message", ex.getMessage());
        return errorMessageMap;
    }

    @ExceptionHandler(SurgeryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleSurgeryNotFoundException(SurgeryNotFoundException ex) {
        Map<String, String> errorMessageMap = new HashMap<>();
        errorMessageMap.put("message", ex.getMessage());
        return errorMessageMap;
    }

}
