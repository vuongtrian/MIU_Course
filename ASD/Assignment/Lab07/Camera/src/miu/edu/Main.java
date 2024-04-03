package miu.edu;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        RecordReceiver recordReceiver = new RecordReceiver();
        UnpaidHandler unpaidHandler = new UnpaidHandler(null);
        NotRegisteredHandler notRegisteredHandler = new NotRegisteredHandler(unpaidHandler);
        SpeedHandler speedHandler = new SpeedHandler(notRegisteredHandler);
        StolenHandler stolenHandler = new StolenHandler(speedHandler);

        recordReceiver.setDetectHandler(stolenHandler);
        try {
            recordReceiver.getRecord(new Record(1, "IOWA123", 70.00));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
