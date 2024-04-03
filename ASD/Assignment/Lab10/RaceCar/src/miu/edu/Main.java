package miu.edu;

public class Main {

    public static void main(String[] args) {
	// write your code here
        HistoryList historyList = new HistoryList();
        HighSpeed highSpeed = new HighSpeed(null);
        MiddleSpeed middleSpeed = new MiddleSpeed(highSpeed);
        LowSpeed lowSpeed = new LowSpeed(middleSpeed);
        CarController carController = new CarController();
        carController.setChainOfHandler(lowSpeed);
        carController.addObserver(new Logger());

        Car car = new Car();
        FasterCommand fasterCommand = new FasterCommand(carController);
        car.setCurrentSpeed(fasterCommand.execute(car));
        historyList.addCommand(fasterCommand);
        car.setCurrentSpeed(fasterCommand.execute(car));
    }
}
