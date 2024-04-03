package customers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class CustomerCollection {
	List<Customer> customers = new ArrayList<Customer>();
	
	public void add(Customer customer) {
		customers.add(customer);
	}
	
	public void print() {
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}

	public Iterator<Customer> filterAddressIterator(Predicate<Customer> predicate){
		return new AddressIterator<Customer>(customers, predicate);
	}

	public void print(Iterator<Customer> customers) {
		while (customers.hasNext()) {
			System.out.println(customers.next());
		}
	}

	public Iterator<Customer> oddPositionIterator(){
		return new OddPositionIterator<Customer>(customers);
	}

}
