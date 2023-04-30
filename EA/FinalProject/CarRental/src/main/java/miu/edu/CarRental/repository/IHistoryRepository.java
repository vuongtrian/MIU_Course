package miu.edu.CarRental.repository;

import miu.edu.CarRental.domain.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHistoryRepository extends JpaRepository<History, Long> {
    public List<History> findByCustomerNumber (long customerNumber);
    public List<History> findByLicensePlate (String licensePlate);
}
