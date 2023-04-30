package miu.edu.CarFleet.service.dto;

public class CarDTO {
    private String licensePlate;
    private String type;
    private String brand;
    private double price;
    private String status;

    public CarDTO() {
    }

    public CarDTO(String licensePlate, String type, String brand, double price, String status) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.brand = brand;
        this.price = price;
        this.status = status;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "licensePlate='" + licensePlate + '\'' +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
