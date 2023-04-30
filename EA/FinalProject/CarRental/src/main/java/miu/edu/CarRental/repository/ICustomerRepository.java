package miu.edu.CarRental.repository;

import miu.edu.CarRental.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByCustomerNumberAndNameAndEmail(Long customerNumber, String name, String email);

    List<Customer> findByCustomerNumberAndName(Long customerNumber, String name);

    List<Customer> findByCustomerNumberAndEmail(Long customerNumber, String email);

    List<Customer> findByNameAndEmail(String name, String email);

    List<Customer> findByCustomerNumber(Long customerNumber);

    List<Customer> findByName(String name);

    List<Customer> findByEmail(String email);
}
