package bank.domain;

public interface InterestStrategy {
    double calInterest(String type, double balance);
}
