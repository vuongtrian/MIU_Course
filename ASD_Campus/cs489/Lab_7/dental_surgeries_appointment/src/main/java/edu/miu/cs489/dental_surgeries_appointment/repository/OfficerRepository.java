package edu.miu.cs489.dental_surgeries_appointment.repository;

import edu.miu.cs489.dental_surgeries_appointment.model.Officer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficerRepository extends JpaRepository<Officer, Long> {
}
