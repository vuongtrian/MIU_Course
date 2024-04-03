package miu.edu;

public class FasterCommand implements Command{
    private CarController carController;

    public FasterCommand(CarController carController) {
        this.carController = carController;
    }

    @Override
    public int execute(Car car) {
        return carController.increase(car);
    }

    @Override
    public int  unExecute(Car car) {
        return carController.decrease(car);
    }
}
