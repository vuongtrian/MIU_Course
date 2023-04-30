package miu.edu.CarRental.repository;

import miu.edu.CarRental.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IRentalRepository extends JpaRepository<Rental, Long> {

    @Query(value = "SELECT * FROM \"PUBLIC\".\"RENTAL\" WHERE CUSTOMER_ID= :customerId", nativeQuery = true)
    List<Rental> findByCustomerCustomerNumber (@Param("customerId") long customerId);
}
