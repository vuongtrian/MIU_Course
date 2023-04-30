package miu.edu.CarRental.service.dto;

import java.util.Date;

public class RentalDTO {

    private long id;
    private String licensePlate;

    private String location;

    private Date fromDate;

    private Date toDate;

    private String state;

    private String paymentType;

    private double paymentAmount;

    private CustomerDTO customerDto;

    public RentalDTO() {
    }

    public RentalDTO(long id, String licensePlate, String location, Date fromDate, Date toDate, String state, String paymentType, double paymentAmount, CustomerDTO customerDto) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.location = location;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.state = state;
        this.paymentType = paymentType;
        this.paymentAmount = paymentAmount;
        this.customerDto = customerDto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public CustomerDTO getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDTO customerDto) {
        this.customerDto = customerDto;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    @Override
    public String toString() {
        return "RentalDTO{" +
                "licensePlate='" + licensePlate + '\'' +
                ", location='" + location + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", state='" + state + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", paymentAmount='" + paymentAmount + '\'' +
                ", customerDto=" + customerDto +
                '}';
    }
}
