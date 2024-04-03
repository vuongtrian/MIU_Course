package packagehandling.with.cor;

public class PackageHandler {
	private Handler chainOfHandlers;
		
	public void setChainOfHandlers(Handler chainOfHandlers) {
		this.chainOfHandlers = chainOfHandlers;
	}

	public void handlePackage(Package thePackage) {
		chainOfHandlers.handle(thePackage);
	}
}
