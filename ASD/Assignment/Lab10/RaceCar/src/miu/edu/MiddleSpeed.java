package miu.edu;

public class MiddleSpeed extends Handler {
    public MiddleSpeed(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public int increase(int currentSpeed) {
        if(currentSpeed >= 40 && currentSpeed < 80) {
            return currentSpeed + 2;
        } else {
            return nextHandler.increase(currentSpeed);
        }
    }

    @Override
    public int decrease(int currentSpeed) {
        if(currentSpeed >= 40 && currentSpeed < 80) {
            return currentSpeed - 2;
        } else {
            return nextHandler.increase(currentSpeed);
        }
    }
}
