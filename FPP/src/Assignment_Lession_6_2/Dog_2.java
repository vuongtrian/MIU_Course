package Assignment_Lession_6_2;

public class Dog_2 extends Pet{
    private double weight;

    public Dog_2(String name, double weight) {
        super(name);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
