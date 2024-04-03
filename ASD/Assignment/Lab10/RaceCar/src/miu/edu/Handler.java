package miu.edu;

public abstract class Handler {
    protected Handler nextHandler;

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract int increase(int currentSpeed);
    public abstract int decrease(int currentSpeed);

}
