package bank.domain;

public class MiddleInterestCalculator implements InterestStrategy{
    @Override
    public double calInterest(String type, double balance) {
        if(type.equals("Saving")) {
            return balance * 0.02;
        } else {
            return balance * 0.025;
        }
    }
}
