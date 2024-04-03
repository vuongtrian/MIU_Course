package packagehandling.with.cor;

public abstract class Handler {
	protected Handler nextHandler;
	
	
	public Handler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public Handler getNextHandler() {
		return nextHandler;
	}

	public abstract void handle(Package thePackage);
}
