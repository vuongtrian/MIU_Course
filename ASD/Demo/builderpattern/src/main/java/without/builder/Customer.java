package without.builder;

public class Customer {
	private String firstName;
	private String lastname;
	private String phone;
	private String email;
	private int age;
	private int numberOfChildren;
	private int shoesize;
	private boolean isMarried;
	private double yearlyIncome;
	private double yearlyAmountSpendOnShoes;
	
	public Customer(String firstName, String lastname, String phone, String email, int age, int numberOfChildren,
			int shoesize, boolean isMarried, double yearlyIncome, double yearlyAmountSpendOnShoes) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.age = age;
		this.numberOfChildren = numberOfChildren;
		this.shoesize = shoesize;
		this.isMarried = isMarried;
		this.yearlyIncome = yearlyIncome;
		this.yearlyAmountSpendOnShoes = yearlyAmountSpendOnShoes;
	}
	
	public Customer() {
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastname=" + lastname + ", phone=" + phone + ", email=" + email
				+ ", age=" + age + ", numberOfChildren=" + numberOfChildren + ", shoesize=" + shoesize + ", isMarried="
				+ isMarried + ", yearlyIncome=" + yearlyIncome + ", yearlyAmountSpendOnShoes="
				+ yearlyAmountSpendOnShoes + "]";
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

	public void setShoesize(int shoesize) {
		this.shoesize = shoesize;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	public void setYearlyIncome(double yearlyIncome) {
		this.yearlyIncome = yearlyIncome;
	}

	public void setYearlyAmountSpendOnShoes(double yearlyAmountSpendOnShoes) {
		this.yearlyAmountSpendOnShoes = yearlyAmountSpendOnShoes;
	}
	
	

}
