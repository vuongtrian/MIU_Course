package edu.miu.cs489.dental_surgeries_appointment.service;

import edu.miu.cs489.dental_surgeries_appointment.dto.surgery.SurgeryRequest;
import edu.miu.cs489.dental_surgeries_appointment.dto.surgery.SurgeryResponse;
import edu.miu.cs489.dental_surgeries_appointment.model.Surgery;

import java.util.List;

public interface SurgeryService {
    SurgeryResponse getSurgery(Long id);
    SurgeryResponse createSurgery(SurgeryRequest surgery);
    SurgeryResponse updateSurgery(Long surgeryId, SurgeryRequest surgery);
    void deleteSurgery(Long id);
    List<SurgeryResponse> getAllSurgery();
}
