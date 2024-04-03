package miu.edu;

public class Record {
    private int id;
    private String licensePlate;
    private double speed;

    public Record() {
    }

    public Record(int id, String licensePlate, double speed) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.speed = speed;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", speed=" + speed +
                '}';
    }
}
