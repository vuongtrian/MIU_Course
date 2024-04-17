package edu.miu.cs489.dental_surgeries_appointment.service;

import edu.miu.cs489.dental_surgeries_appointment.dto.appointment.AppointmentRequest;
import edu.miu.cs489.dental_surgeries_appointment.dto.appointment.AppointmentResponse;
import edu.miu.cs489.dental_surgeries_appointment.model.Appointment;

import java.util.List;

public interface AppointmentService {
    AppointmentResponse createAppointment(AppointmentRequest appointmentRequest);
    AppointmentResponse updateAppointment(Long appointmentId, Appointment appointmentRequest);
    void deleteAppointment(Long appointmentId);
    List<AppointmentResponse> getAllAppointments();
    AppointmentResponse getAppointmentById(Long appointmentId);

}
