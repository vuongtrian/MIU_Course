package counter;

public class TripleDigit extends CountState{

    public TripleDigit(Counter counter) {
        super(counter);
    }

    @Override
    public void add() {
        counter.setCount(counter.getCount() + 3);
        checkDigitNumber();
    }

    @Override
    public void subtract() {
        counter.setCount(counter.getCount() - 3);
        checkDigitNumber();
    }

    @Override
    public void checkDigitNumber() {
        if (counter.getCount() > 99) {
            counter.setCount(counter.getCount());
        }
    }
}
