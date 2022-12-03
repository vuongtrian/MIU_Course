package Lab_3_4;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(2.3, 5.4);
        System.out.println("Area of Triangle is " + triangle.computeArea());

        Rectangle rectangle = new Rectangle(4.2,5.5);
        System.out.println("Area of Rectangle is " + rectangle.computeArea());

        Circle circle = new Circle(2.5);
        System.out.println("Area of Circle is " + circle.computeArea());
    }
}
