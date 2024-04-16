package edu.miu.cs489.dental_surgeries_appointment.service.impl;

import edu.miu.cs489.dental_surgeries_appointment.model.Appointment;
import edu.miu.cs489.dental_surgeries_appointment.repository.AppointmentRepository;
import edu.miu.cs489.dental_surgeries_appointment.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentImpl implements AppointmentService {
    private AppointmentRepository appointmentRepository;
    @Override
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment getAppointmentById(Long appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("No appointment found with id " + appointmentId));
    }
}
