package miu.edu.CarRental.service.dto;

import miu.edu.CarRental.domain.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter {
    public static Customer getCustomerFromCustomerDto (CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setCustomerNumber(customerDTO.getCustomerNumber());
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        return customer;
    }

    public static Customer getCustomerFromCustomerDtoWihtoutId (CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        return customer;
    }

    public static CustomerDTO getCustomerDtoFromCustomer (Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerNumber(customer.getCustomerNumber());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        return customerDTO;
    }

    public static List<CustomerDTO> getListCustomerDto (List<Customer> customers) {
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        for (Customer customer : customers) {
            customerDTOList.add(getCustomerDtoFromCustomer(customer));
        }
        return customerDTOList;
    }
}
