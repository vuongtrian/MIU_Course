package edu.miu.cs489.dental_surgeries_appointment.service;

import edu.miu.cs489.dental_surgeries_appointment.dto.dentist.DentistRequest;
import edu.miu.cs489.dental_surgeries_appointment.dto.dentist.DentistResponse;
import edu.miu.cs489.dental_surgeries_appointment.model.Dentist;

import java.util.List;

public interface DentistService {
    DentistResponse getDentist(Long id);
    DentistResponse createDentist(DentistRequest dentist);
    DentistResponse updateDentist(Long dentistId, DentistRequest dentist);
    void deleteDentist(Long id);
    List<DentistResponse> getAllDentists();
}
