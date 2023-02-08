package prob02;

public class App {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.getVehicle("Bus");
        vehicle.startEngine();
    }
}
