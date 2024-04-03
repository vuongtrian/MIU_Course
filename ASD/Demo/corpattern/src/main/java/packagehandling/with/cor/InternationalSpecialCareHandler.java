package packagehandling.with.cor;

public class InternationalSpecialCareHandler extends Handler {

	public InternationalSpecialCareHandler(Handler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handle(Package thePackage) {
		if (thePackage.isInternational() && thePackage.isSpecialCare()) {
			System.out.println("Handle international special care package");
		} else {
			nextHandler.handle(thePackage);
		}
	}
}
