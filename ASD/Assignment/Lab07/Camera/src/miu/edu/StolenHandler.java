package miu.edu;

public class StolenHandler extends DetectHandler{

    public StolenHandler(DetectHandler nextCamera) {
        super(nextCamera);
    }

    @Override
    public void detect(String content) {
        if(content.equals("stolen")) {
            System.out.println("This car is stolen. Notify the police");
        } else {
            nextCamera.detect(content);
        }
    }
}
