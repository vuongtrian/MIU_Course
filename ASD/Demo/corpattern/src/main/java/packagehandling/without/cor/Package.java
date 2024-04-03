package packagehandling.without.cor;

public class Package {
	private int packageNumber;
	private int weight;
	private boolean rushPriority;
	private boolean international;
	private boolean specialCare;
	private double contentPrice;

	public Package(int packageNumber, int weight, boolean rushPriority, boolean international, boolean specialCare,
			double contentPrice) {
		super();
		this.packageNumber = packageNumber;
		this.weight = weight;
		this.rushPriority = rushPriority;
		this.international = international;
		this.specialCare = specialCare;
		this.contentPrice = contentPrice;
	}

	public int getPackageNumber() {
		return packageNumber;
	}

	public void setPackageNumber(int packageNumber) {
		this.packageNumber = packageNumber;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isRushPriority() {
		return rushPriority;
	}

	public void setRushPriority(boolean rushPriority) {
		this.rushPriority = rushPriority;
	}

	public boolean isInternational() {
		return international;
	}

	public void setInternational(boolean international) {
		this.international = international;
	}

	public boolean isSpecialCare() {
		return specialCare;
	}

	public void setSpecialCare(boolean specialCare) {
		this.specialCare = specialCare;
	}

	public double getContentPrice() {
		return contentPrice;
	}

	public void setContentPrice(double contentPrice) {
		this.contentPrice = contentPrice;
	}

}
