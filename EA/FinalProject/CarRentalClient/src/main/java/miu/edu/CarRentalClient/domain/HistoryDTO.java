package miu.edu.CarRentalClient.domain;

//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import java.util.Date;

public class HistoryDTO {
    private long id;

    private long customerNumber;
    private String licensePlate;
    private String brand;
    private String type;

//    @Temporal(TemporalType.DATE)
    private Date fromDate;

//    @Temporal(TemporalType.DATE)
    private Date toDate;
    private String state;

    public HistoryDTO() {
    }

    public HistoryDTO(long customerNumber, String licensePlate, String brand, String type, Date fromDate, Date toDate, String state) {
        this.customerNumber = customerNumber;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.type = type;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "HistoryDTO{" +
                "id=" + id +
                ", customerNumber=" + customerNumber +
                ", licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", state='" + state + '\'' +
                '}';
    }
}
