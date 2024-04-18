package edu.miu.cs489.dental_surgeries_appointment.service.impl;

import edu.miu.cs489.dental_surgeries_appointment.dto.appointment.AppointmentRequest;
import edu.miu.cs489.dental_surgeries_appointment.dto.appointment.AppointmentResponse;
import edu.miu.cs489.dental_surgeries_appointment.exception.AppointmentNotFoundException;
import edu.miu.cs489.dental_surgeries_appointment.model.Appointment;
import edu.miu.cs489.dental_surgeries_appointment.repository.AppointmentRepository;
import edu.miu.cs489.dental_surgeries_appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public AppointmentResponse createAppointment(AppointmentRequest appointmentRequest) {
        Appointment appointment = appointmentRepository.save(new Appointment(
                appointmentRequest.dateTime()
        ));
        return new AppointmentResponse(
                appointment.getAppointmentId(),
                appointment.getDateTime()
        );
    }

    @Override
    public AppointmentResponse updateAppointment(Long appointmentId, Appointment appointmentRequest) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException("No appointment found with id " + appointmentId));
        appointment.setDateTime(appointmentRequest.getDateTime());
        appointmentRepository.save(appointment);
        return new AppointmentResponse(
                appointment.getAppointmentId(),
                appointment.getDateTime()
        );
    }

    @Override
    public void deleteAppointment(Long appointmentId) {
        appointmentRepository.findById(appointmentId)
                .ifPresentOrElse(
                        appointment -> appointmentRepository.deleteById(appointmentId),
                        () -> {
                            throw new AppointmentNotFoundException("No appointment found with id " + appointmentId);
                        }
                );
    }

    @Override
    public List<AppointmentResponse> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(appointment -> new AppointmentResponse(
                        appointment.getAppointmentId(),
                        appointment.getDateTime()
                )).toList();
    }

    @Override
    public AppointmentResponse getAppointmentById(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new AppointmentNotFoundException("No appointment found with id " + appointmentId));
        return new AppointmentResponse(
                appointment.getAppointmentId(),
                appointment.getDateTime()
        );
    }
}
