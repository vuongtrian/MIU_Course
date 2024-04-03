package miu.edu;

public class SpeedHandler extends DetectHandler{

    public SpeedHandler(DetectHandler nextCamera) {
        super(nextCamera);
    }

    @Override
    public void detect(String content) {
        if(content.equals("speed")) {
            System.out.println("Drive too fast. Send the owner a speeding ticket");
        } else {
            nextCamera.detect(content);
        }
    }
}
