package miu.edu.CarFleet;

import miu.edu.CarFleet.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableJms
@EnableScheduling
public class CarFleetApplication implements CommandLineRunner {

	@Autowired
	private CarService carService;

	public static void main(String[] args) {
		SpringApplication.run(CarFleetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
