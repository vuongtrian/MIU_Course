package Lab_3_4;

public class Rectangle {

    private double width;
    private double height;

    public Rectangle(double width, double length) {
        this.width = width;
        this.height = length;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return height;
    }

    public double computeArea() {
        return width * height;
    }
}
