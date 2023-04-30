package miu.edu.CarRental.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Rental {

    @Id
    @GeneratedValue
    private long id;

    private String licensePlate;

    private String location;

    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Temporal(TemporalType.DATE)
    private Date toDate;


    private String state;

    private double  paymentAmount;

    private String paymentType;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Rental() {
    }

    public Rental(String licensePlate, String location, Date fromDate, Date toDate, String state, double paymentAmount, String paymentType, Customer customer) {
        this.licensePlate = licensePlate;
        this.location = location;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.state = state;
        this.paymentAmount = paymentAmount;
        this.paymentType = paymentType;
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", location='" + location + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", state='" + state + '\'' +
                ", paymentAmount='" + paymentAmount + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", customer=" + customer +
                '}';
    }
}

