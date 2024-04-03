package counter;

public class SingleDigit extends CountState{

    public SingleDigit(Counter counter) {
        super(counter);
    }

    @Override
    public void add() {
        counter.setCount(counter.getCount() + 1);
        checkDigitNumber();
    }

    @Override
    public void subtract() {
        counter.setCount(counter.getCount() - 1);
        checkDigitNumber();
    }

    @Override
    public void checkDigitNumber() {
        if (counter.getCount() > 9) {
            CountState newState = new DoubleDigit(counter);
            counter.setCountState(newState);
            counter.setCount(counter.getCount());
        }
    }
}
