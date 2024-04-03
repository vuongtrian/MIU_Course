package counter;

public abstract class CountHandler {
    protected CountHandler next;

    public CountHandler(CountHandler next) {
        this.next = next;
    }

    public abstract void printColor(int  count);
}
