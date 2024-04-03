package miu.edu;

public class UnpaidHandler extends DetectHandler{

    public UnpaidHandler(DetectHandler nextCamera) {
        super(nextCamera);
    }

    @Override
    public void detect(String content) {
        if(content.equals("unpaid")) {
            System.out.println("Owner has one or more unpaid tickets, notify the police");
        }
    }
}
