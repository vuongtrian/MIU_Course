package application;

import framework.Service;

@Service
public class Calculator {

    int number = 0;

    public void addNumber(int addedNumber) {
        System.out.println(number + addedNumber);
    }
}
