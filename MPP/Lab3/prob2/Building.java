package lesson3.labs.prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private double maintenanceCost;
    private List<Apartment> apartments = new ArrayList<>();

    public Building(double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }

    public void addApartment(double rent) {
        Apartment apartment = new Apartment(rent);
        apartments.add(apartment);
    }

    public double calProfit() {
        double sum = 0;
        for (Apartment a: apartments) {
            sum += a.getRent();
        }
        return sum - maintenanceCost;
    }
}
