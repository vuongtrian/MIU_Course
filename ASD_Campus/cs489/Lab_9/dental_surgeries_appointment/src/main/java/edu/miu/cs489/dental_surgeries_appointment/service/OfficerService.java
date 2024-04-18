package edu.miu.cs489.dental_surgeries_appointment.service;

import edu.miu.cs489.dental_surgeries_appointment.dto.officer.OfficerRequest;
import edu.miu.cs489.dental_surgeries_appointment.dto.officer.OfficerResponse;
import edu.miu.cs489.dental_surgeries_appointment.model.Officer;

import java.util.List;

public interface OfficerService {
    OfficerResponse findById(Long id);
    List<OfficerResponse> findAll();
    OfficerResponse save(OfficerRequest officerRequest);
    void delete(Long id);
    OfficerResponse update(Long officialId, OfficerRequest officerRequest);
}
