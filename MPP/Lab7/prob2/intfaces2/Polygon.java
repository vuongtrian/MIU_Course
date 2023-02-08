package lesson5.lecture.intfaces2;

public interface Polygon extends ClosedCurve{
    @Override
    default double computePerimeter() {
        double sum = 0;
        for(double side : getLengths()) {
            sum += side;
        }
        return sum;
    }

    double[] getLengths();
}
