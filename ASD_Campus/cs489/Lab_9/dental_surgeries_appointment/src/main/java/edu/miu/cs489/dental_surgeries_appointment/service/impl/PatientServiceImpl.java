package edu.miu.cs489.dental_surgeries_appointment.service.impl;

import edu.miu.cs489.dental_surgeries_appointment.dto.address.AddressResponse;
import edu.miu.cs489.dental_surgeries_appointment.dto.appointment.AppointmentResponse;
import edu.miu.cs489.dental_surgeries_appointment.dto.patient.PatientRequest;
import edu.miu.cs489.dental_surgeries_appointment.dto.patient.PatientResponse;
import edu.miu.cs489.dental_surgeries_appointment.exception.PatientNotFoundException;
import edu.miu.cs489.dental_surgeries_appointment.model.Address;
import edu.miu.cs489.dental_surgeries_appointment.model.Appointment;
import edu.miu.cs489.dental_surgeries_appointment.model.Patient;
import edu.miu.cs489.dental_surgeries_appointment.repository.PatientRepository;
import edu.miu.cs489.dental_surgeries_appointment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public PatientResponse getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        List<AppointmentResponse> appointmentResponses =
                patient.getAppointments().isEmpty() ?
                        new ArrayList<>() :
                        patient.getAppointments().stream()
                                .map(appointment -> new AppointmentResponse(
                                        appointment.getAppointmentId(),
                                        appointment.getDateTime()))
                                .toList();
        return new PatientResponse(
                patient.getPatientId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getEmail(),
                patient.getPhone(),
                patient.getBirthDate(),
                new AddressResponse(
                        patient.getAddress().getAddressId(),
                        patient.getAddress().getStreet(),
                        patient.getAddress().getCity(),
                        patient.getAddress().getState(),
                        patient.getAddress().getZipCode()
                ),
                appointmentResponses
        );
    }

    @Override
    public PatientResponse createPatient(PatientRequest patient) {
        List<Appointment> appointments = patient.appointments().isEmpty() ?
                new ArrayList<>() :
                patient.appointments().stream()
                        .map(appointmentRequest -> new Appointment(
                                appointmentRequest.dateTime()))
                        .toList();
        Patient savedPatient = patientRepository.save(
                new Patient(
                        patient.firstName(),
                        patient.lastName(),
                        patient.email(),
                        patient.phone(),
                        patient.birthDate(),
                        new Address(
                                patient.address().street(),
                                patient.address().city(),
                                patient.address().state(),
                                patient.address().zipCode()
                        ),
                        appointments
                )
        );
        List<AppointmentResponse> appointmentResponses = savedPatient.getAppointments().isEmpty() ?
                new ArrayList<>() :
                savedPatient.getAppointments().stream()
                        .map(appointment -> new AppointmentResponse(
                                appointment.getAppointmentId(),
                                appointment.getDateTime()
                        )).toList();
        return new PatientResponse(
                savedPatient.getPatientId(),
                savedPatient.getFirstName(),
                savedPatient.getLastName(),
                savedPatient.getEmail(),
                savedPatient.getPhone(),
                savedPatient.getBirthDate(),
                new AddressResponse(
                        savedPatient.getAddress().getAddressId(),
                        savedPatient.getAddress().getStreet(),
                        savedPatient.getAddress().getCity(),
                        savedPatient.getAddress().getState(),
                        savedPatient.getAddress().getZipCode()
                ),
                appointmentResponses
        );
    }

    @Override
    public PatientResponse updatePatient(Long patientId, PatientRequest patientRequest) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        patient.setFirstName(patientRequest.firstName());
        patient.setLastName(patientRequest.lastName());
        patient.setEmail(patientRequest.email());
        patient.setPhone(patientRequest.phone());
        patient.setBirthDate(patientRequest.birthDate());
        patient.setAddress(new Address(
                patientRequest.address().street(),
                patientRequest.address().city(),
                patientRequest.address().state(),
                patientRequest.address().zipCode()
        ));
        List<Appointment> appointments = patientRequest.appointments().isEmpty() ?
                new ArrayList<>() :
                patientRequest.appointments().stream()
                        .map(appointmentRequest -> new Appointment(
                                appointmentRequest.dateTime()))
                        .toList();
        patient.setAppointments(appointments);
        Patient savedPatient = patientRepository.save(patient);

        List<AppointmentResponse> appointmentResponses = savedPatient.getAppointments().isEmpty() ?
                new ArrayList<>() :
                savedPatient.getAppointments().stream()
                        .map(appointment -> new AppointmentResponse(
                                appointment.getAppointmentId(),
                                appointment.getDateTime()
                        )).toList();
        return new PatientResponse(
                savedPatient.getPatientId(),
                savedPatient.getFirstName(),
                savedPatient.getLastName(),
                savedPatient.getEmail(),
                savedPatient.getPhone(),
                savedPatient.getBirthDate(),
                new AddressResponse(
                        savedPatient.getAddress().getAddressId(),
                        savedPatient.getAddress().getStreet(),
                        savedPatient.getAddress().getCity(),
                        savedPatient.getAddress().getState(),
                        savedPatient.getAddress().getZipCode()
                ),
                appointmentResponses
        );
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.findById(id)
                .ifPresentOrElse(
                        patient -> patientRepository.deleteById(id),
                        () -> {
                            throw new PatientNotFoundException("Patient not found");
                        }
                );
    }

    @Override
    public List<PatientResponse> getAllPatients() {
        return patientRepository.findAll().stream()
                .map(patient -> {
                    List<AppointmentResponse> appointmentResponses = patient.getAppointments().stream()
                            .map(appointment -> new AppointmentResponse(appointment.getAppointmentId(), appointment.getDateTime()))
                            .collect(Collectors.toList());
                    return new PatientResponse(
                            patient.getPatientId(),
                            patient.getFirstName(),
                            patient.getLastName(),
                            patient.getEmail(),
                            patient.getPhone(),
                            patient.getBirthDate(),
                            new AddressResponse(
                                    patient.getAddress().getAddressId(),
                                    patient.getAddress().getStreet(),
                                    patient.getAddress().getCity(),
                                    patient.getAddress().getState(),
                                    patient.getAddress().getZipCode()
                            ),
                            appointmentResponses);
                })
                .collect(Collectors.toList());
    }
}
