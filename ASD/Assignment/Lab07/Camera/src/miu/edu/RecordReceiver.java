package miu.edu;

public class RecordReceiver {
    private DetectHandler detectHandler;

    public void setDetectHandler(DetectHandler detectHandler) {
        this.detectHandler = detectHandler;
    }

    public void getRecord(Record record) {
        if(record.getSpeed() > 65) {
            detect("speed");
        }
    }

    public void detect (String content) {
        detectHandler.detect(content);
    }
}
