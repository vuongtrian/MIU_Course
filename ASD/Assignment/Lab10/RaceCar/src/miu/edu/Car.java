package miu.edu;

public class Car {
    private int currentSpeed;

    public Car() {
        this.currentSpeed = 0;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int speed) {
        this.currentSpeed = speed;
    }
}
