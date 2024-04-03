package webshop.order;

public class Customer {
	private String name;
	private String email;
	private String phone;

	public Customer(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"name='" + name + '\'' +
				", email='" + email + '\'' +
				", phone='" + phone + '\'' +
				'}';
	}
}
