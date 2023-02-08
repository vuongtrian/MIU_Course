package lesson3.labs.prob3;

public class Admin {
	public static double computeTotalRent(Properties[] properties) {
		double totalRent = 0;

		for (Properties p : properties) {
			totalRent += p.computeRent();
		}

		return totalRent;
	}
}
