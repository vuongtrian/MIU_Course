package webshop;

import framework.FWContext;

public class FWApplication {
	
	@SuppressWarnings("unused")
	private static FWContext fwContext = null;

	public static void run(Class<? extends Runnable> appClass) {
		try {
			Runnable app = appClass.getDeclaredConstructor().newInstance();
			fwContext = new FWContext(app);
			app.run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
