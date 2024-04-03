package with.adapter;

public class KilometerDistanceAdapterImpl implements DistanceAdapter {
	private DistanceCalculator distanceCalculator;

	public double computeDistanceInKilometers(String origin, String destination) {
		double distanceInMiles = distanceCalculator.computeDistance(origin, destination);
		return distanceInMiles * 1.609344;
	}

	public void setDistanceCalculator(DistanceCalculator distanceCalculator) {
		this.distanceCalculator = distanceCalculator;
	}

}
