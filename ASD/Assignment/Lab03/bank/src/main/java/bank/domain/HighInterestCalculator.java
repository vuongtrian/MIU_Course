package bank.domain;

public class HighInterestCalculator implements InterestStrategy{

    @Override
    public double calInterest(String type, double balance) {
        if(type.equals("Saving")) {
            return balance * 0.04;
        } else {
            return balance * 0.025;
        }
    }
}
