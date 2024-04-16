package edu.miu.cs489.dental_surgeries_appointment.service;

import edu.miu.cs489.dental_surgeries_appointment.model.Surgery;

import java.util.List;

public interface SurgeryService {
    Surgery getSurgery(Long id);
    Surgery createSurgery(Surgery surgery);
    Surgery updateSurgery(Surgery surgery);
    void deleteSurgery(Long id);
    List<Surgery> getAllSurgery();
}
