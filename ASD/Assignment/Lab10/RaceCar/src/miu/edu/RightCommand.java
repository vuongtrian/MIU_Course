package miu.edu;

public class RightCommand implements Command{
    private CarController carController;

    public RightCommand(CarController carController) {
        this.carController = carController;
    }

    @Override
    public int execute(Car car) {
        carController.turnRight();
        return car.getCurrentSpeed();
    }

    @Override
    public int unExecute(Car car) {
        carController.turnLeft();
        return car.getCurrentSpeed();
    }
}
