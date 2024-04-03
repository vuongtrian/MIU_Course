package miu.edu;

public class CarController extends Subject{
    private Handler chainOfHandler;

    public void setChainOfHandler(Handler chainOfHandler) {
        this.chainOfHandler = chainOfHandler;
    }

    public int increase(Car car) {
        int updateSpeed = chainOfHandler.increase(car.getCurrentSpeed());
//        System.out.println("Current speed: " + updateSpeed);
        notify(updateSpeed);
        return updateSpeed;
    }

    public int decrease(Car car) {
        int updateSpeed = chainOfHandler.decrease(car.getCurrentSpeed());
//        System.out.println("Current speed: " + updateSpeed);
        notify(updateSpeed);
        return updateSpeed;
    }

    public void turnLeft() {
        System.out.println("Car is turning left");
    }

    public void turnRight() {
        System.out.println("Car is turning right");
    }

    public void jump() {
        System.out.println("Car is jumping");
    }
}
