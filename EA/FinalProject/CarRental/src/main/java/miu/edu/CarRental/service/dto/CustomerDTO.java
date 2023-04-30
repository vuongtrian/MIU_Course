package miu.edu.CarRental.service.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class CustomerDTO {
    private long customerNumber;

    private String name;
    private String email;

    public CustomerDTO() {
    }

    public CustomerDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber=" + customerNumber +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
