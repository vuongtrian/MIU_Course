package bank.domain;

public class LowInterestCalculator implements InterestStrategy{
    @Override
    public double calInterest(String type, double balance) {
        if(type.equals("Saving")) {
            return balance * 0.01;
        } else {
            return balance * 0.015;
        }
    }
}
