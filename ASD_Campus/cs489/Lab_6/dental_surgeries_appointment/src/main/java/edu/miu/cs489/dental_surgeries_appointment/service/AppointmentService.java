package edu.miu.cs489.dental_surgeries_appointment.service;

import edu.miu.cs489.dental_surgeries_appointment.model.Appointment;

import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(Appointment appointment);
    Appointment updateAppointment(Appointment appointment);
    void deleteAppointment(Long appointmentId);
    List<Appointment> getAllAppointments();
    Appointment getAppointmentById(Long appointmentId);

}
