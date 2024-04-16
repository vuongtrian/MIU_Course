package edu.miu.cs489.dental_surgeries_appointment.service;

import edu.miu.cs489.dental_surgeries_appointment.model.Officer;

import java.util.List;

public interface OfficerService {
    Officer findById(Long id);
    List<Officer> findAll();
    Officer save(Officer officer);
    void delete(Long id);
    Officer update(Officer officer);
}
