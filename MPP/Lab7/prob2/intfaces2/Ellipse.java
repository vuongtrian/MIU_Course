package lesson5.lecture.intfaces2;

public class Ellipse implements ClosedCurve{
    private double semiMajor;
    private double e;

    public Ellipse(double semi_major, double e) {
        this.semiMajor = semi_major;
        this.e = e;
    }

    @Override
    public double computePerimeter() {
        return 4 * semiMajor * e;
    }
}
