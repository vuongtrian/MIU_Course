package counter;

public class GreenHandler extends CountHandler{

    public GreenHandler(CountHandler next) {
        super(next);
    }

    @Override
    public void printColor(int count) {
        if(count % 2 == 0 && count >= 10 && (count != 12 || count != 13)) {
            System.out.println("Green");
        } else {
            next.printColor(count);
        }
    }
}
