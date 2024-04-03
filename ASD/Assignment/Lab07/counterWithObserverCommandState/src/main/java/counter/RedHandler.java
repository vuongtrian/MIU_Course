package counter;

public class RedHandler extends CountHandler {

    public RedHandler(CountHandler next) {
        super(next);
    }

    @Override
    public void printColor(int count) {
        if(count % 2 == 0 && count < 10 && (count == 12 || count == 13)) {
            System.out.println("Red");
        } else {
            next.printColor(count);
        }
    }
}
