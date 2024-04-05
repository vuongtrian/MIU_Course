package cs489.miu.edu.hotel_reservation_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HotelReservationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelReservationServiceApplication.class, args);
		System.out.println("Application is running");
	}

}
