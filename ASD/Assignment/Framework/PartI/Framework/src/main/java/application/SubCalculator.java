package application;

import framework.FWContext;
import framework.Service;
import framework.Value;

@Service
public class SubCalculator implements ICalculator{

    @Value("smtpserver")
    private String smtpserver;

    public SubCalculator() {
    }

    @Override
    public void method1() {
        System.out.println("Method 1 from SubCalculator");
    }

    @Override
    public void method2() {
        System.out.println("Method 2 from SubCalculator");
    }

    public void showValue() {
        System.out.println("SubCalculator smtpserver = " + smtpserver);
        
        FWContext context = FWApplication.getFWContext();
        if (context != null) {
        	context.puhlishEvent("SubCalculator has value smtpserver = " + smtpserver);
        }
    }
}
