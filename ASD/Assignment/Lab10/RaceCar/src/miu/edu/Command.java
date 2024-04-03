package miu.edu;

public interface Command {
    public int execute(Car car);
    public int unExecute(Car car);
}
