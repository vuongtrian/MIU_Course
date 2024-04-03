package application;

import framework.Service;

@Service
public class AddCalculator implements ICalculator{

    public AddCalculator() {
    }

    @Override
    public void method1() {
        System.out.println("Method 1 from AddCalculator");
    }

    @Override
    public void method2() {
        System.out.println("Method 2 from AddCalculator");
    }
}