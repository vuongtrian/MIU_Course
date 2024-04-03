package with.adapter;

public class Client {

	public static void main(String[] args) {
		DistanceCalculator distanceCalculator = new DistanceCalculator();
		double distanceInMiles = distanceCalculator.computeDistance("city1", "city2");
		System.out.println("The distance between city1 and city2 ="+distanceInMiles+" miles");
		
		DistanceAdapter distanceAdapter = new KilometerDistanceAdapterImpl();
		distanceAdapter.setDistanceCalculator(distanceCalculator);

		double distanceInKilometers = distanceAdapter.computeDistanceInKilometers("city3", "city4");
		System.out.println("The distance between city3 and city4 ="+distanceInKilometers+" kilometers");

	}

}

