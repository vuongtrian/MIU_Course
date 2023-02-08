package lesson3.labs.prob2;

import java.util.ArrayList;
import java.util.List;

public class Landlord {
    private List<Building> buildings = new ArrayList<>();

    public Landlord() {
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public double calTotalProfit() {
        double sum = 0;
        for (Building b: buildings) {
            sum += b.calProfit();
        }
        return sum;
    }
}
