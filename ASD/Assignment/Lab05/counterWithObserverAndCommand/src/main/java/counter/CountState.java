package counter;

public abstract class CountState {
    protected final Counter counter;

    public CountState(Counter counter) {
        this.counter = counter;
    }

    public abstract void add();

    public abstract void subtract();

    public abstract void checkDigitNumber();
}
