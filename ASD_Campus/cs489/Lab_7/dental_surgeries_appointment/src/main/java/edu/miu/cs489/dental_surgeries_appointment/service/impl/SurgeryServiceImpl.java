package edu.miu.cs489.dental_surgeries_appointment.service.impl;

import edu.miu.cs489.dental_surgeries_appointment.dto.address.AddressResponse;
import edu.miu.cs489.dental_surgeries_appointment.dto.appointment.AppointmentResponse;
import edu.miu.cs489.dental_surgeries_appointment.dto.surgery.SurgeryRequest;
import edu.miu.cs489.dental_surgeries_appointment.dto.surgery.SurgeryResponse;
import edu.miu.cs489.dental_surgeries_appointment.exception.SurgeryNotFoundException;
import edu.miu.cs489.dental_surgeries_appointment.model.Address;
import edu.miu.cs489.dental_surgeries_appointment.model.Appointment;
import edu.miu.cs489.dental_surgeries_appointment.model.Surgery;
import edu.miu.cs489.dental_surgeries_appointment.repository.SurgeryRepository;
import edu.miu.cs489.dental_surgeries_appointment.service.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SurgeryServiceImpl implements SurgeryService {
    @Autowired
    private SurgeryRepository surgeryRepository;

    @Override
    public SurgeryResponse getSurgery(Long id) {
        Surgery surgery = surgeryRepository.findById(id)
                .orElseThrow(() -> new SurgeryNotFoundException("Surgery not found"));
        List<AppointmentResponse> appointmentResponses =
                surgery.getAppointments().isEmpty() ?
                        new ArrayList<>() :
                        surgery.getAppointments().stream()
                                .map(appointment -> new AppointmentResponse(
                                        appointment.getAppointmentId(),
                                        appointment.getDateTime()))
                                .toList();
        return new SurgeryResponse(
                surgery.getSurgeryId(),
                surgery.getSurgeryName(),
                new AddressResponse(
                        surgery.getAddress().getAddressId(),
                        surgery.getAddress().getStreet(),
                        surgery.getAddress().getCity(),
                        surgery.getAddress().getState(),
                        surgery.getAddress().getZipCode()
                ),
                appointmentResponses
        );
    }

    @Override
    public SurgeryResponse createSurgery(SurgeryRequest surgery) {
        List<Appointment> appointments = surgery.appointments().isEmpty() ?
                new ArrayList<>() :
                surgery.appointments().stream()
                        .map(appointmentRequest -> new Appointment(
                                appointmentRequest.dateTime()))
                        .toList();
        Surgery savedSurgery = surgeryRepository.save(new Surgery(
                surgery.surgeryName(),
                new Address(
                        surgery.address().street(),
                        surgery.address().city(),
                        surgery.address().state(),
                        surgery.address().zipCode()
                ),
                appointments
        ));
        List<AppointmentResponse> appointmentResponses = savedSurgery.getAppointments().isEmpty() ?
                new ArrayList<>() :
                savedSurgery.getAppointments().stream()
                        .map(appointment -> new AppointmentResponse(
                                appointment.getAppointmentId(),
                                appointment.getDateTime()
                        )).toList();
        return new SurgeryResponse(
                savedSurgery.getSurgeryId(),
                savedSurgery.getSurgeryName(),
                new AddressResponse(
                        savedSurgery.getAddress().getAddressId(),
                        savedSurgery.getAddress().getStreet(),
                        savedSurgery.getAddress().getCity(),
                        savedSurgery.getAddress().getState(),
                        savedSurgery.getAddress().getZipCode()
                ),
                appointmentResponses
        );
    }

    @Override
    public SurgeryResponse updateSurgery(Long surgeryId, SurgeryRequest surgeryRequest) {
        Surgery surgery = surgeryRepository.findById(surgeryId)
                .orElseThrow(() -> new SurgeryNotFoundException("Surgery not found"));
        surgery.setSurgeryName(surgery.getSurgeryName());
        surgery.setAddress(new Address(
                surgeryRequest.address().street(),
                surgeryRequest.address().city(),
                surgeryRequest.address().state(),
                surgeryRequest.address().zipCode()
        ));
        List<Appointment> appointments = surgeryRequest.appointments().isEmpty() ?
                new ArrayList<>() :
                surgeryRequest.appointments().stream()
                        .map(appointmentRequest -> new Appointment(
                                appointmentRequest.dateTime()))
                        .toList();
        surgery.setAppointments(appointments);

        Surgery savedSurgery = surgeryRepository.save(surgery);

        List<AppointmentResponse> appointmentResponses = savedSurgery.getAppointments().isEmpty() ?
                new ArrayList<>() :
                savedSurgery.getAppointments().stream()
                        .map(appointment -> new AppointmentResponse(
                                appointment.getAppointmentId(),
                                appointment.getDateTime()
                        )).toList();

        return new SurgeryResponse(
                savedSurgery.getSurgeryId(),
                savedSurgery.getSurgeryName(),
                new AddressResponse(
                        savedSurgery.getAddress().getAddressId(),
                        savedSurgery.getAddress().getStreet(),
                        savedSurgery.getAddress().getCity(),
                        savedSurgery.getAddress().getState(),
                        savedSurgery.getAddress().getZipCode()
                ),
                appointmentResponses
        );
    }

    @Override
    public void deleteSurgery(Long id) {
        surgeryRepository.findById(id)
                .ifPresentOrElse(
                        surgery -> surgeryRepository.deleteById(id),
                        () -> {
                            throw new SurgeryNotFoundException("Surgery not found");
                        }
                );
    }

    @Override
    public List<SurgeryResponse> getAllSurgery() {
        return surgeryRepository.findAll().stream()
                .map(surgery -> {
                    List<AppointmentResponse> appointmentResponses = surgery.getAppointments().stream()
                            .map(appointment -> new AppointmentResponse(appointment.getAppointmentId(), appointment.getDateTime()))
                            .collect(Collectors.toList());
                    return new SurgeryResponse(
                            surgery.getSurgeryId(),
                            surgery.getSurgeryName(),
                            new AddressResponse(
                                    surgery.getAddress().getAddressId(),
                                    surgery.getAddress().getStreet(),
                                    surgery.getAddress().getCity(),
                                    surgery.getAddress().getState(),
                                    surgery.getAddress().getZipCode()
                            ),
                            appointmentResponses
                    );
                })
                .collect(Collectors.toList());
    }
}
