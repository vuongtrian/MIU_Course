package miu.edu;

public class EmailSender extends Observer{

    public void send() {
        System.out.println("Sent email to customer");
    }

    @Override
    public void update() {
        send();
    }
}
