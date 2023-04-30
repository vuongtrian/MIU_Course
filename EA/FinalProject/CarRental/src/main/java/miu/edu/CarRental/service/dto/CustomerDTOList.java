package miu.edu.CarRental.service.dto;

import java.util.ArrayList;
import java.util.Collection;

public class CustomerDTOList {
    private Collection<CustomerDTO> customers = new ArrayList<>();

    public CustomerDTOList() {
    }

    public CustomerDTOList(Collection<CustomerDTO> customers) {
        this.customers = customers;
    }

    public Collection<CustomerDTO> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<CustomerDTO> customers) {
        this.customers = customers;
    }
}
