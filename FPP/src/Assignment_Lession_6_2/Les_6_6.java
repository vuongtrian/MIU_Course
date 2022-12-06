package Assignment_Lession_6_2;

import java.util.ArrayList;
import java.util.List;

public class Les_6_6 {
}

class Property {
    private String address;

    public Property(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public double computeRent() {
        return 0;
    }
}

class House extends Property {
    private double lotSize;

    public House(String address, double lotSize) {
        super(address);
        this.lotSize = lotSize;
    }

    @Override
    public double computeRent() {
        return 0.1 * lotSize;
    }
}

class Condominium extends Property {
    private double numberOfFloor;

    public Condominium(String address, double numberOfFloor) {
        super(address);
        this.numberOfFloor = numberOfFloor;
    }

    public double getNumberOfFloor() {
        return numberOfFloor;
    }

    @Override
    public double computeRent() {
        return 400 * numberOfFloor;
    }
}

class Trailer extends Property {

    public Trailer(String address) {
        super(address);
    }

    @Override
    public double computeRent() {
        return 500;
    }
}

class Admin {
    private List<Property> propertyList = new ArrayList<>();

    public double totalRent() {
        double sum = 0;
        for (Property p: propertyList) {
            sum += p.computeRent();
        }
        return sum;
    }

    public void list() {
        for (Property p: propertyList) {
            if (p instanceof House) {
                p.toString();
            }
        }

        for (Property p: propertyList) {
            if (p instanceof Condominium) {
                p.toString();
            }
        }

        for (Property p: propertyList) {
            if (p instanceof Trailer) {
                p.toString();
            }
        }
    }
}