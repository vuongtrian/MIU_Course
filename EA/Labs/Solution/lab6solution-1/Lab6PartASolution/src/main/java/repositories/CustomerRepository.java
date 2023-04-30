package repositories;

import domain.Customer;
import domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByAddressZip(String zip);
    List<Customer> findByTheordersOrderlinesProductName(String name);
    
    @Query("select c from Customer c where c.address.country = :country")
    List<Customer> getAllCustomersFromCountry(@Param("country")String country);

    @Query("select c from Customer c where c.address.city = :city")
    List<Customer> getAllCustomersFromCity(@Param("city")String amsterdam);

}
