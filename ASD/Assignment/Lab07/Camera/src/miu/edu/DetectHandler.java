package miu.edu;

public abstract class DetectHandler {
    protected DetectHandler nextCamera;

    public DetectHandler(DetectHandler nextCamera) {
        this.nextCamera = nextCamera;
    }

    public DetectHandler getNextCamera() {
        return nextCamera;
    }

    public abstract void detect (String content);
}
