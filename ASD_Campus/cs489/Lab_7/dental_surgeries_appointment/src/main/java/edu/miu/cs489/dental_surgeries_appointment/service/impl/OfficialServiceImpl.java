package edu.miu.cs489.dental_surgeries_appointment.service.impl;

import edu.miu.cs489.dental_surgeries_appointment.dto.officer.OfficerRequest;
import edu.miu.cs489.dental_surgeries_appointment.dto.officer.OfficerResponse;
import edu.miu.cs489.dental_surgeries_appointment.exception.OfficerNotFoundException;
import edu.miu.cs489.dental_surgeries_appointment.model.Officer;
import edu.miu.cs489.dental_surgeries_appointment.repository.OfficerRepository;
import edu.miu.cs489.dental_surgeries_appointment.service.OfficerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficialServiceImpl implements OfficerService {
    @Autowired
    private OfficerRepository officerRepository;

    @Override
    public OfficerResponse findById(Long id) {
        Officer officer = officerRepository.findById(id)
                .orElseThrow(() -> new OfficerNotFoundException("Officer not found"));
        return new OfficerResponse(
                officer.getOfficialId(),
                officer.getUsername(),
                officer.getRole(),
                officer.getFirstName(),
                officer.getLastName(),
                officer.getEmail(),
                officer.getPhone()
        );
    }

    @Override
    public List<OfficerResponse> findAll() {
        return officerRepository.findAll()
                .stream()
                .map(officer -> new OfficerResponse(
                        officer.getOfficialId(),
                        officer.getUsername(),
                        officer.getRole(),
                        officer.getFirstName(),
                        officer.getLastName(),
                        officer.getEmail(),
                        officer.getPhone()
                )).toList();
    }

    @Override
    public OfficerResponse save(OfficerRequest officerRequest) {
        Officer officer = officerRepository.save(new Officer(
                officerRequest.username(),
                officerRequest.password(),
                officerRequest.role(),
                officerRequest.firstName(),
                officerRequest.lastName(),
                officerRequest.email(),
                officerRequest.phone()
        ));
        return new OfficerResponse(
                officer.getOfficialId(),
                officer.getUsername(),
                officer.getRole(),
                officer.getFirstName(),
                officer.getLastName(),
                officer.getEmail(),
                officer.getPhone()
        );
    }

    @Override
    public void delete(Long id) {
        officerRepository.findById(id)
                .ifPresentOrElse(officer -> officerRepository.deleteById(id),
                        () -> {
                    throw new OfficerNotFoundException("Officer not found");
                        });
    }

    @Override
    public OfficerResponse update(Long officialId, OfficerRequest officerRequest) {
        Officer officer = officerRepository.findById(officialId)
                .orElseThrow(() -> new OfficerNotFoundException("Officer not found"));
        officer.setUsername(officerRequest.username());
        officer.setPassword(officerRequest.password());
        officer.setRole(officerRequest.role());
        officer.setFirstName(officerRequest.firstName());
        officer.setLastName(officerRequest.lastName());
        officer.setEmail(officerRequest.email());
        officer.setPhone(officerRequest.phone());
        Officer savedOfficial = officerRepository.save(officer);
        return new OfficerResponse(
                savedOfficial.getOfficialId(),
                savedOfficial.getUsername(),
                savedOfficial.getRole(),
                savedOfficial.getFirstName(),
                savedOfficial.getLastName(),
                savedOfficial.getEmail(),
                savedOfficial.getPhone()
        );
    }
}
