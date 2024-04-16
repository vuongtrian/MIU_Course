package edu.miu.cs489.dental_surgeries_appointment.service;

import edu.miu.cs489.dental_surgeries_appointment.model.Dentist;

import java.util.List;

public interface DentistService {
    Dentist getDentist(Long id);
    Dentist createDentist(Dentist dentist);
    Dentist updateDentist(Dentist dentist);
    void deleteDentist(Long id);
    List<Dentist> getAllDentists();
}
