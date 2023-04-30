package miu.edu.CarFleetClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarFleetClientApplication implements CommandLineRunner {

	@Autowired
	private CarFleetGateway carFleetGateway;

	public static void main(String[] args) {
		SpringApplication.run(CarFleetClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


//		------------------ add some car ------------------
		/*
		carFleetGateway.addCar("F772", "Everest", "Ford", 35.14);
		carFleetGateway.addCar("F773", "Everest", "Ford", 35.14);
		carFleetGateway.addCar("F774", "Everest", "Ford", 35.14);
		carFleetGateway.addCar("F775", "Everest", "Ford", 35.14);
		carFleetGateway.addCar("T123", "Camry", "Toyota", 25.35);
		carFleetGateway.addCar("T124", "Camry", "Toyota", 25.35);
		carFleetGateway.addCar("T125", "Camry", "Toyota", 25.35);
		carFleetGateway.addCar("T126", "Camry", "Toyota", 25.35);
		carFleetGateway.addCar("T456", "Rav4", "Toyota", 33.72);
		carFleetGateway.addCar("T457", "Rav4", "Toyota", 33.72);
		carFleetGateway.addCar("T458", "Rav4", "Toyota", 33.72);
		carFleetGateway.addCar("T459", "Rav4", "Toyota", 33.72);
		carFleetGateway.addCar("H233", "Accord", "Honda", 23.91);
		carFleetGateway.addCar("H234", "Accord", "Honda", 23.91);
		carFleetGateway.addCar("H235", "Accord", "Honda", 23.91);
		carFleetGateway.addCar("H236", "Accord", "Honda", 23.91);
		carFleetGateway.addCar("H441", "Civic", "Honda", 20.15);
		carFleetGateway.addCar("H442", "Civic", "Honda", 20.15);
		carFleetGateway.addCar("H443", "Civic", "Honda", 20.15);
		carFleetGateway.addCar("H444", "Civic", "Honda", 20.15);
		carFleetGateway.addCar("P123", "Prius", "Toyota", 25.35);
		carFleetGateway.addCar("P124", "Prius", "Toyota", 25.35);
		carFleetGateway.addCar("P125", "Prius", "Toyota", 25.35);
		carFleetGateway.addCar("P126", "Prius", "Toyota", 25.35);
		*/

//		------------------ get all car ------------------
		/*
		System.out.println(carFleetGateway.getAllCar());
		 */

//		------------------ get a car ------------------
		/*
		System.out.println(carFleetGateway.getCar("T456"));
		 */

//		------------------ remove a car ------------------
		/*
		carFleetGateway.removeCar("F772");
		System.out.println(carFleetGateway.getCar("F772"));
		*/

//		------------------ update a car ------------------
		/*
		CarDTO updated = carFleetGateway.updateCar(new CarDTO("T456", "Rav4", "Toyota", 33.42, "available"));
		System.out.println(carFleetGateway.getCar("T456"));
		 */

//		------------------ search a car ------------------
		/*
		System.out.println(carFleetGateway.searchCar("Rav4", "Toyota", 33.72));
		 */
	}


}
