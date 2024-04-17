package edu.miu.cs489.dental_surgeries_appointment.service.impl;

import edu.miu.cs489.dental_surgeries_appointment.dto.appointment.AppointmentResponse;
import edu.miu.cs489.dental_surgeries_appointment.dto.dentist.DentistRequest;
import edu.miu.cs489.dental_surgeries_appointment.dto.dentist.DentistResponse;
import edu.miu.cs489.dental_surgeries_appointment.exception.DentistNotFoundException;
import edu.miu.cs489.dental_surgeries_appointment.model.Appointment;
import edu.miu.cs489.dental_surgeries_appointment.model.Dentist;
import edu.miu.cs489.dental_surgeries_appointment.repository.DentistRepository;
import edu.miu.cs489.dental_surgeries_appointment.service.DentistService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DentistServiceImpl implements DentistService {
    private DentistRepository dentistRepository;

    @Override
    public DentistResponse getDentist(Long id) {
        Dentist dentist = dentistRepository.findById(id)
                .orElseThrow(() -> new DentistNotFoundException("Dentist not found"));
        List<AppointmentResponse> appointmentResponses =
                dentist.getAppointments().isEmpty() ?
                        new ArrayList<>() :
                        dentist.getAppointments().stream()
                                .map(appointment -> new AppointmentResponse(
                                        appointment.getAppointmentId(),
                                        appointment.getDateTime()))
                                .toList();

        return new DentistResponse(
                dentist.getDentistId(),
                dentist.getFirstName(),
                dentist.getLastName(),
                dentist.getEmail(),
                dentist.getPhoneNumber(),
                dentist.getSpecialization(),
                appointmentResponses
        );
    }

    @Override
    public DentistResponse createDentist(DentistRequest dentist) {

        List<Appointment> appointments = dentist.appointments().isEmpty() ?
                new ArrayList<>() :
                dentist.appointments().stream()
                        .map(appointmentRequest -> new Appointment(
                                appointmentRequest.dateTime()))
                        .toList();

        Dentist savedDentist = dentistRepository.save(
                new Dentist(dentist.firstName(),
                        dentist.lastName(),
                        dentist.email(),
                        dentist.phoneNumber(),
                        dentist.specialization(),
                        appointments));

        List<AppointmentResponse> appointmentResponses = savedDentist.getAppointments().isEmpty() ?
                new ArrayList<>() :
                savedDentist.getAppointments().stream()
                        .map(appointment -> new AppointmentResponse(
                                appointment.getAppointmentId(),
                                appointment.getDateTime()
                        )).toList();
        return new DentistResponse(
                savedDentist.getDentistId(),
                savedDentist.getFirstName(),
                savedDentist.getLastName(),
                savedDentist.getEmail(),
                savedDentist.getPhoneNumber(),
                savedDentist.getSpecialization(),
                appointmentResponses
        );
    }

    @Override
    public DentistResponse updateDentist(Long dentistId, DentistRequest dentistRequest) {
        Dentist dentist = dentistRepository.findById(dentistId)
                .orElseThrow(() -> new DentistNotFoundException("Dentist not found"));
        dentist.setFirstName(dentistRequest.firstName());
        dentist.setLastName(dentistRequest.lastName());
        dentist.setEmail(dentistRequest.email());
        dentist.setPhoneNumber(dentistRequest.phoneNumber());
        dentist.setSpecialization(dentistRequest.specialization());

        List<Appointment> appointments = dentistRequest.appointments().isEmpty() ?
                new ArrayList<>() :
                dentistRequest.appointments().stream()
                        .map(appointmentRequest -> new Appointment(
                                appointmentRequest.dateTime()))
                        .toList();
        dentist.setAppointments(appointments);

        List<AppointmentResponse> appointmentResponses = dentist.getAppointments().isEmpty() ?
                new ArrayList<>() :
                dentist.getAppointments().stream()
                        .map(appointment -> new AppointmentResponse(
                                appointment.getAppointmentId(),
                                appointment.getDateTime()
                        )).toList();

        return new DentistResponse(
                dentist.getDentistId(),
                dentist.getFirstName(),
                dentist.getLastName(),
                dentist.getEmail(),
                dentist.getPhoneNumber(),
                dentist.getSpecialization(),
                appointmentResponses
        );
    }

    @Override
    public void deleteDentist(Long id) {
        dentistRepository.findById(id)
                .ifPresentOrElse(
                        dentist -> dentistRepository.deleteById(id),
                        () -> {
                            throw new DentistNotFoundException("Dentist not found");
                        }
                );
    }

    @Override
    public List<DentistResponse> getAllDentists() {
        return dentistRepository.findAll().stream()
                .map(dentist -> {
                    List<AppointmentResponse> appointmentResponses = dentist.getAppointments().stream()
                            .map(appointment -> new AppointmentResponse(appointment.getAppointmentId(), appointment.getDateTime()))
                            .collect(Collectors.toList());
                    return new DentistResponse(
                            dentist.getDentistId(),
                            dentist.getFirstName(),
                            dentist.getLastName(),
                            dentist.getEmail(),
                            dentist.getPhoneNumber(),
                            dentist.getSpecialization(),
                            appointmentResponses
                    );
                })
                .collect(Collectors.toList());
    }
}
