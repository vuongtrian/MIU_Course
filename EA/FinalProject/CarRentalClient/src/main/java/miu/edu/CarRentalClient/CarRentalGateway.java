package miu.edu.CarRentalClient;

import miu.edu.CarRentalClient.domain.CustomerDTO;
import miu.edu.CarRentalClient.domain.CustomerDTOList;
import miu.edu.CarRentalClient.domain.RentalDTO;
import miu.edu.CarRentalClient.domain.RentalDTOList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class CarRentalGateway {

    RestTemplate restTemplate = new RestTemplate();
    private String serverUrl = "http://localhost:8081/customers";


    public CustomerDTO addCustomer (String name, String email) {
        CustomerDTO newCustomer = new CustomerDTO(name,email);
        restTemplate.postForLocation(serverUrl, newCustomer);
        return newCustomer;
    }

    public CustomerDTO getCustomer (long customerId) {
        try {
            CustomerDTO customer = restTemplate.getForObject(serverUrl+"/{customerNumber}", CustomerDTO.class, customerId);
            return customer;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public CustomerDTOList getAllCustomer () {
        CustomerDTOList customers = restTemplate.getForObject(serverUrl, CustomerDTOList.class);
        return customers;
    }

    public void removeCustomer (long customerNumber) {
        restTemplate.delete(serverUrl+"/{customerNumber}", customerNumber);
    }

    public CustomerDTO updateCustomer (CustomerDTO updatedCustomer) {
        CustomerDTO currentCustomer = getCustomer(updatedCustomer.getCustomerNumber());
        if (currentCustomer == null) {
            System.out.println("Failed to update customer!");
        } else {
            restTemplate.put(serverUrl+"/{customerNumber}", updatedCustomer, updatedCustomer.getCustomerNumber());
        }
        return updatedCustomer;
    }
    public CustomerDTOList serchCustomer (String name, String email) {
        CustomerDTOList customers = restTemplate.getForObject(serverUrl+"/search?name={name}&email={email}",
                CustomerDTOList.class, name, email);
        if (customers == null) {
            System.out.println("Not available customer!");
        }
        return customers;
    }

    public RentalDTO reserveCar (String brand, String type, long customerId, String fromDate, String toDate, String location) {

        Map<String, String> mapValue = new HashMap<>();
        mapValue.put("brand", brand);
        mapValue.put("type", type);
        mapValue.put("customerId", String.valueOf(customerId));
        mapValue.put("fromDate", fromDate);
        mapValue.put("toDate", toDate);
        mapValue.put("location", location);
        mapValue.put("operation", "reserve");

        RentalDTO rental = restTemplate.postForObject(
                serverUrl+"/cars?brand={brand}&type={type}&customerId={customerId}&fromDate={fromDate}&toDate={toDate}&location={location}&operation={operation}",
                null, RentalDTO.class, mapValue);
        return rental;
    }

    public RentalDTOList rentCar (long customerId) {
        Map<String, String> mapValue = new HashMap<>();
        mapValue.put("customerId", String.valueOf(customerId));
        mapValue.put("operation", "rent");
        RentalDTOList rentalList = restTemplate.postForObject(
                serverUrl+"/cars?customerId={customerId}&&operation={operation}",
                null,RentalDTOList.class,mapValue);
        return rentalList;
    }

    public RentalDTOList payForRent (long customerId) {
        Map<String, String> mapValue = new HashMap<>();
        mapValue.put("customerId", String.valueOf(customerId));
        mapValue.put("operation", "payment");
        RentalDTOList rentalList = restTemplate.postForObject(
                serverUrl+"/cars?customerId={customerId}&&operation={operation}",
                null,RentalDTOList.class,mapValue);
        return rentalList;
    }
}
