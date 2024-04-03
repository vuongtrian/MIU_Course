package miu.edu;

public class JumpCommand implements Command{
    private CarController carController;

    public JumpCommand(CarController carController) {
        this.carController = carController;
    }

    @Override
    public int execute(Car car) {
        carController.jump();
        return car.getCurrentSpeed();
    }

    @Override
    public int unExecute(Car car) {
        System.out.println("Car is standing");
        return car.getCurrentSpeed();
    }
}
