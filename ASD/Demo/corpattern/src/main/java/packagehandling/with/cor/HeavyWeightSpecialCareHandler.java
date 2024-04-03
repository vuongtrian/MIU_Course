package packagehandling.with.cor;

public class HeavyWeightSpecialCareHandler extends Handler {

	public HeavyWeightSpecialCareHandler(Handler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handle(Package thePackage) {
		if (thePackage.isSpecialCare() && thePackage.getWeight()>100) {
			System.out.println("Handle special care package larger than 100 pounds");
		} else {
			nextHandler.handle(thePackage);
		}


	}

}
