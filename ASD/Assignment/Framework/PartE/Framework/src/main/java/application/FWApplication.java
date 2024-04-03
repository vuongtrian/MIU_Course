package application;

import framework.FWContext;

public class FWApplication {

    private static FWContext fwContext = null;

    public static void main(String[] args){}

    public static void run(Class<? extends Runnable> appClass) {
        try {
            Runnable app = appClass.getDeclaredConstructor().newInstance();
            fwContext = new FWContext(app);
            app.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public FWContext getFWContext() {
    	return fwContext;
    }
}
