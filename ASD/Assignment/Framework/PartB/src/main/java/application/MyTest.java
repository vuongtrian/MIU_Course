package application;

import framework.Autowired;
import framework.Qualifier;
import framework.Service;

@Service
public class MyTest {

    @Autowired
    @Qualifier("subCalculator")
    ICalculator calculator;

    public void testMethod () {
        calculator.method1();
    }


    public void setCalculator(AddCalculator calculator) {
        this.calculator = calculator;
    }
}
