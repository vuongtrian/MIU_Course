package application;

import framework.Service;

@Service
public class SubCalculator implements ICalculator{

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
}
