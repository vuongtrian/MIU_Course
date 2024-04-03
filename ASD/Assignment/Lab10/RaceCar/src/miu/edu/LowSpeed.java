package miu.edu;

public class LowSpeed extends Handler {
    public LowSpeed(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public int increase(int currentSpeed) {
        if(currentSpeed < 40) {
            return currentSpeed + 1;
        } else {
            return nextHandler.increase(currentSpeed);
        }
    }

    @Override
    public int decrease(int currentSpeed) {
        if (currentSpeed == 0) {
            return 0;
        }else if(currentSpeed < 40) {
            return currentSpeed - 1;
        } else {
            return nextHandler.increase(currentSpeed);
        }
    }
}
