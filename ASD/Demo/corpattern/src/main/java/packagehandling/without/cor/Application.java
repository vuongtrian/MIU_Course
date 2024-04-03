package packagehandling.without.cor;

public class Application {
	public static void main(String[] args) {
		PackageHandler packageHandler = new PackageHandler();
		packageHandler.handlePackage(new Package(1543, 56, false, true, true, 300.0));	
		packageHandler.handlePackage(new Package(1223, 156, true, false, true, 154.45));	
		packageHandler.handlePackage(new Package(545, 12, false, false, false, 30.0));	
	}
}
