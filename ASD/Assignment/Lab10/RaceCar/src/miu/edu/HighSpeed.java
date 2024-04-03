package miu.edu;

public class HighSpeed extends Handler {
    public HighSpeed(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public int increase(int currentSpeed) {
        return currentSpeed + 3;
    }

    @Override
    public int decrease(int currentSpeed) {
        return currentSpeed -3;
    }
}
