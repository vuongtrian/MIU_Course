package counter;

public class OrangeHandler extends CountHandler{

    public OrangeHandler(CountHandler next) {
        super(next);
    }

    @Override
    public void printColor(int count) {
        if (count % 2 != 0 && count >= 15 && (count != 17 || count != 19)) {
            System.out.println("Orange");
        }
    }
}
