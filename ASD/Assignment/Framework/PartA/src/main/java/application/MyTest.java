package application;

import framework.Autowired;
import framework.Service;

@Service
public class MyTest {

    @Autowired
    Calculator calculator;

    public void testMethod () {
        calculator.addNumber(5);
    }
}
