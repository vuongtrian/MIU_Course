package application;

import framework.Inject;



public class Application implements Runnable {
	@Inject
	MyTest myTest;
	
	public static void main(String[] args) {
		FWApplication.run(Application.class);
	}

	@Override
	public void run() {
		myTest.testMethod();
	}
}

