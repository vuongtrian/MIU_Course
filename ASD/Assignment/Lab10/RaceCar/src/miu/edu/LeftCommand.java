package miu.edu;

public class LeftCommand implements Command{
    private CarController carController;

    public LeftCommand(CarController carController) {
        this.carController = carController;
    }

    @Override
    public int execute(Car car) {
        carController.turnLeft();
        return car.getCurrentSpeed();
    }

    @Override
    public int unExecute(Car car) {
        carController.turnRight();
        return car.getCurrentSpeed();
    }
}
