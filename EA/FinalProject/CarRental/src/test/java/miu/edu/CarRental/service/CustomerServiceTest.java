package miu.edu.CarRental.service;

import miu.edu.CarRental.domain.Customer;
import miu.edu.CarRental.repository.ICustomerRepository;
import miu.edu.CarRental.service.dto.CustomerDTO;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

public class CustomerServiceTest {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerRepository repository;

    @BeforeClass
    public void addOneCustomer () {
        Customer customer = new Customer("Test", "test@gmail.com");
        repository.save(customer);
    }

}
