package miu.edu.CarRental;

import miu.edu.CarRental.domain.CarList;
import miu.edu.CarRental.domain.Customer;
import miu.edu.CarRental.intergration.rest.CarFleetGateway;
import miu.edu.CarRental.intergration.rest.CarFleetProperties;
import miu.edu.CarRental.repository.ICustomerRepository;
import miu.edu.CarRental.repository.IRentalRepository;
import miu.edu.CarRental.service.CustomerService;
import miu.edu.CarRental.service.RentalService;
import miu.edu.CarRental.service.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;

@SpringBootApplication
@EnableJms
@EnableScheduling
@EnableConfigurationProperties(CarFleetProperties.class)
public class CarRentalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CarRentalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
