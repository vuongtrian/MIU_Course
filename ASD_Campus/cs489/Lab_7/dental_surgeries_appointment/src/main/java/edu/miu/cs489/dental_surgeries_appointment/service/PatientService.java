package edu.miu.cs489.dental_surgeries_appointment.service;

import edu.miu.cs489.dental_surgeries_appointment.dto.patient.PatientRequest;
import edu.miu.cs489.dental_surgeries_appointment.dto.patient.PatientResponse;
import edu.miu.cs489.dental_surgeries_appointment.model.Patient;

import java.util.List;

public interface PatientService {
    PatientResponse getPatientById(Long id);
    PatientResponse createPatient(PatientRequest patient);
    PatientResponse updatePatient(Long patientId, PatientRequest patient);
    void deletePatient(Long id);
    List<PatientResponse> getAllPatients();
}
