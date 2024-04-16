package edu.miu.cs489.dental_surgeries_appointment.service.impl;

import edu.miu.cs489.dental_surgeries_appointment.model.Officer;
import edu.miu.cs489.dental_surgeries_appointment.repository.OfficerRepository;
import edu.miu.cs489.dental_surgeries_appointment.service.OfficerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficialServiceImpl implements OfficerService {
    private OfficerRepository officerRepository;
    @Override
    public Officer findById(Long id) {
        return officerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Officer not found"));
    }

    @Override
    public List<Officer> findAll() {
        return officerRepository.findAll();
    }

    @Override
    public Officer save(Officer officer) {
        return officerRepository.save(officer);
    }

    @Override
    public void delete(Long id) {
        officerRepository.deleteById(id);
    }

    @Override
    public Officer update(Officer officer) {
        return officerRepository.save(officer);
    }
}
