package miu.edu;

public class SlowerCommand implements Command{
    private CarController carController;

    public SlowerCommand(CarController carController) {
        this.carController = carController;
    }

    @Override
    public int execute(Car car) {
        return carController.decrease(car);
    }

    @Override
    public int unExecute(Car car) {
        return carController.increase(car);
    }
}
