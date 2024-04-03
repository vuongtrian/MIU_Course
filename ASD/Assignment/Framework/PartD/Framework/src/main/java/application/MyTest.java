package application;

import framework.Autowired;
import framework.Qualifier;
import framework.Service;

@Service
public class MyTest implements IMyTest{

    @Autowired
    @Qualifier("subCalculator")
    ICalculator calculator;

    @Override
    public void testMethod () {
//        calculator.method1();
        calculator.showValue();
    }


    public void setCalculator(AddCalculator calculator) {
        this.calculator = calculator;
    }
}
