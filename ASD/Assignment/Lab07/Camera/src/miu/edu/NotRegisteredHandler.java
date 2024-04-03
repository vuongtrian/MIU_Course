package miu.edu;

public class NotRegisteredHandler extends DetectHandler{
    public NotRegisteredHandler(DetectHandler nextCamera) {
        super(nextCamera);
    }

    @Override
    public void detect(String content) {
        if(content.equals("not registered")) {
            System.out.println("car is currently not registered, send the owner a ticket");
        } else {
            nextCamera.detect(content);
        }
    }
}
