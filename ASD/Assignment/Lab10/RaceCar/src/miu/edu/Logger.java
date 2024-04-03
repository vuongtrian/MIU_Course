package miu.edu;

public class Logger extends Observer{


    @Override
    public void update(int speed) {
        System.out.println("Current speed: " + speed);
    }
}
