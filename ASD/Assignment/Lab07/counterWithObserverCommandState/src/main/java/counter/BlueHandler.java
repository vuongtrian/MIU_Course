package counter;

public class BlueHandler extends CountHandler{

    public BlueHandler(CountHandler next) {
        super(next);
    }

    @Override
    public void printColor(int count) {
        if(count % 2 != 0 && count < 15 && (count == 17 || count == 19)) {
            System.out.println("Blue");
        } else {
            next.printColor(count);
        }
    }
}
