package without.proxy;

public class Customer {
	private int customerId;
	private String name;

	public Customer(int customerId, String name) {
		super();
		this.customerId = customerId;
		this.name = name;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + "]";
	}
}
