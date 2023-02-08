package lesson3.labs.prob2;

public class Main {
    public static void main(String[] args) {

        Landlord landlord = new Landlord();

        Building b1 = new Building(200);
        landlord.addBuilding(b1);
        b1.addApartment(300);
        b1.addApartment(400);
        b1.addApartment(100);
        System.out.println("Total profit: " + landlord.calTotalProfit());
    }
}
