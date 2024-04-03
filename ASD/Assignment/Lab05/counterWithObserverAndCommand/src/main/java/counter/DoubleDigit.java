package counter;

public class DoubleDigit extends CountState{

    public DoubleDigit(Counter counter) {
        super(counter);
    }

    @Override
    public void add() {
        counter.setCount(counter.getCount() + 2);
        checkDigitNumber();
    }

    @Override
    public void subtract() {
        counter.setCount(counter.getCount() - 2);
        checkDigitNumber();
    }

    @Override
    public void checkDigitNumber() {
        if (counter.getCount() > 99) {
            CountState newState = new TripleDigit(counter);
            counter.setCountState(newState);
            counter.setCount(counter.getCount());
        }
    }
}
