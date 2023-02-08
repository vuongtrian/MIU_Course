package lesson5.lecture.intfaces2;

public class EQTriangle implements Polygon{

    private double side;

    public EQTriangle(double side) {
        this.side = side;
    }

    @Override
    public double[] getLengths() {
        return new double[] {3 * side};
    }
}
