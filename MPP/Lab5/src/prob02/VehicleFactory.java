package prob02;

public class VehicleFactory {
    private VehicleFactory(){};

    public static Vehicle getVehicle(String v){
        switch (v) {
            case "Bus":
                return new Bus();
            case "Truck":
                return new Truck();
            case "Car":
                return new Car();
            case "ElectricCar":
                return new ElectricCar();
            default:
                return null;
        }
    }
}
