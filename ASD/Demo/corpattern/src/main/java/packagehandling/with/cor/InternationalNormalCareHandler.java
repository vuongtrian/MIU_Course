package packagehandling.with.cor;

public class InternationalNormalCareHandler extends Handler {

	public InternationalNormalCareHandler(Handler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handle(Package thePackage) {
		if (thePackage.isInternational() && !thePackage.isSpecialCare()) {
			System.out.println("Handle international package");
		} else {
			nextHandler.handle(thePackage);
		}
	}

}
