package edu.miu.cs489.dental_surgeries_appointment.service.impl;

import edu.miu.cs489.dental_surgeries_appointment.model.Dentist;
import edu.miu.cs489.dental_surgeries_appointment.repository.DentistRepository;
import edu.miu.cs489.dental_surgeries_appointment.service.DentistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DentistServiceImpl implements DentistService {
    private DentistRepository dentistRepository;
    @Override
    public Dentist getDentist(Long id) {
        return dentistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dentist not found"));
    }

    @Override
    public Dentist createDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public Dentist updateDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }

    @Override
    public void deleteDentist(Long id) {
        dentistRepository.deleteById(id);
    }

    @Override
    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }
}
