package counter;

public class DecrementCommand implements Command{

    private Counter counter;

    public DecrementCommand(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void execute() {
        counter.decrement();
    }

    @Override
    public void unExecute() {
        counter.increment();
    }
}
