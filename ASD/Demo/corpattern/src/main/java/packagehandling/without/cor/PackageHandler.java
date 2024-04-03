package packagehandling.without.cor;

public class PackageHandler {
	public void handlePackage(Package thePackage) {
		if (thePackage.isInternational()) {
			if (thePackage.isSpecialCare()) {
               System.out.println("Handle international special care package");
			} else {
				System.out.println("Handle international package");
			}
		} else if (thePackage.isSpecialCare()) {
			if (thePackage.getWeight()>100) {
				System.out.println("Handle special care package larger than 100 pounds");
			} else {
				System.out.println("Handle special care package smaller than 100 pounds");
			}
		} else if (thePackage.isRushPriority()) {
			if (thePackage.getWeight()>30) {
				System.out.println("Handle rush package larger than 30 pounds");
			} else {
				System.out.println("Handle rush package smaller than 30 pounds");
			}
		} else if (thePackage.getContentPrice()>10000.0) {
			if (thePackage.getContentPrice()>1000000.0) {
				System.out.println("Handle expensive package with price > 1000000.0");
			} else {
				System.out.println("Handle expensive package with price > 10000.0");
			}						
		}
		else {
			System.out.println("Handle normal package");
		}	
	}
}
