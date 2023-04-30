package miu.edu.CarRentalClient;

import miu.edu.CarRentalClient.domain.CustomerDTO;
import miu.edu.CarRentalClient.domain.HistoryDTOList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class CarRentalClientApplication implements CommandLineRunner {

	@Autowired
	private CarRentalGateway carRentalGateway;

	@Autowired
	private HistoryGateway historyGateway;

	public static void main(String[] args) {
		SpringApplication.run(CarRentalClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


//		------------------ create customer ------------------
		/*
		carRentalGateway.addCustomer("Jacky", "jacky@gmail.com");
		carRentalGateway.addCustomer("Mary", "mary@gmail.com");
		carRentalGateway.addCustomer("Thor", "thor@gmail.com");
		carRentalGateway.addCustomer("Andy", "andy@gmail.com");
		carRentalGateway.addCustomer("Tommy", "Tommy@gmail.com");
		carRentalGateway.addCustomer("Smith", "Smith@gmail.com");
		*/

//		------------------ get customer ------------------
		/*
		System.out.println(carRentalGateway.getCustomer(1));
		 */

//		------------------ get all customer ------------------
		/*
		System.out.println(carRentalGateway.getAllCustomer());
		 */

//		------------------ remove customer number 2 ------------------
		/*
		carRentalGateway.removeCustomer(2);
		System.out.println(carRentalGateway.getCustomer(2));
		*/

//		------------------ update name customer number 3 ------------------
		/*
		CustomerDTO customer = carRentalGateway.getCustomer(3);
		customer.setName("NewName");
		System.out.println(carRentalGateway.updateCustomer(customer));
		 */

//		------------------ search customer ------------------
		/*
		System.out.println(carRentalGateway.serchCustomer("Andy", "andy@gmail.com"));
		 */

//		------------------ customer 1 & 4 & 5 revered some car ------------------
		/*
		carRentalGateway.reserveCar("Honda", "Civic", 1,
				"2022-04-15", "2022-04-20", "Iowa");
		carRentalGateway.reserveCar("Toyota", "Rav4", 1,
				"2022-04-15", "2022-04-20", "Iowa");
		carRentalGateway.reserveCar("Honda", "Civic", 4,
				"2022-04-10", "2022-04-25", "Iowa");
		carRentalGateway.reserveCar("Toyota", "Rav4", 4,
				"2022-04-11", "2022-04-14", "Iowa");
		carRentalGateway.reserveCar("Toyota", "Prius", 5,
				"2022-05-15", "2022-05-25", "Iowa");
		carRentalGateway.reserveCar("Ford", "Everest", 5,
				"2022-05-15", "2022-05-25", "Iowa");
		*/

//		------------------ customer 5 picked up car ------------------
		/*
		carRentalGateway.rentCar(5);
		*/

//		------------------ customer 5 return car and pay for rent ------------------
		/*
		carRentalGateway.payForRent(5);
		 */

//		------------------ Get all data from a customer 5 ------------------
		/*
		HistoryDTOList customerHistory = historyGateway.getCustomerHistory(5);
		System.out.println(customerHistory);
		 */

//		------------------ Get all data from a particular car ------------------
		/*
		HistoryDTOList carHistory = historyGateway.getCarHistory("H441");
		System.out.println(carHistory);
		*/
	}
}
