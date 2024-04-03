package application;

import framework.FWContext;

public class Application{


    public static void main(String[] args) {
        FWContext fwContext = new FWContext();

        MyTest myTest = (MyTest) fwContext.getBean(MyTest.class);
        myTest.testMethod();

    }
}
