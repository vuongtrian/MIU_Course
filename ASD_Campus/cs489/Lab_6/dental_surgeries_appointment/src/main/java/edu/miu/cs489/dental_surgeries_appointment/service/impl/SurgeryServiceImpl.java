package edu.miu.cs489.dental_surgeries_appointment.service.impl;

import edu.miu.cs489.dental_surgeries_appointment.model.Surgery;
import edu.miu.cs489.dental_surgeries_appointment.repository.SurgeryRepository;
import edu.miu.cs489.dental_surgeries_appointment.service.SurgeryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurgeryServiceImpl implements SurgeryService {
    private SurgeryRepository surgeryRepository;
    @Override
    public Surgery getSurgery(Long id) {
        return surgeryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Surgery not found"));
    }

    @Override
    public Surgery createSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    @Override
    public Surgery updateSurgery(Surgery surgery) {
        return surgeryRepository.save(surgery);
    }

    @Override
    public void deleteSurgery(Long id) {
        surgeryRepository.deleteById(id);
    }

    @Override
    public List<Surgery> getAllSurgery() {
        return surgeryRepository.findAll();
    }
}
