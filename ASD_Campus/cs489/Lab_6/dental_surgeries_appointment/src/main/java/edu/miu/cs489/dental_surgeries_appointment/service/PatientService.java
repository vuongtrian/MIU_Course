package edu.miu.cs489.dental_surgeries_appointment.service;

import edu.miu.cs489.dental_surgeries_appointment.model.Patient;

import java.util.List;

public interface PatientService {
    Patient getPatientById(Long id);
    Patient createPatient(Patient patient);
    Patient updatePatient(Patient patient);
    void deletePatient(Long id);
    List<Patient> getAllPatients();
}
