package miu.edu.CarRental.controller;

import miu.edu.CarRental.service.DateService;
import miu.edu.CarRental.service.ICustomerService;
import miu.edu.CarRental.service.IHistoryService;
import miu.edu.CarRental.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

//    @Autowired
//    private IHistoryService historyService;

    //    get one customer
    @GetMapping("/customers/{customerNumber}")
    public ResponseEntity<?> getCustomer (@PathVariable long customerNumber) {
        CustomerDTO customer = customerService.getOneCustomer(customerNumber);
        if (customer == null) {
            return new ResponseEntity<String>(
                    "Customer with number " + customerNumber + " is not available",
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CustomerDTO>(customer, HttpStatus.OK);
    }

    //    get all customer
    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomer () {
        CustomerDTOList customers = new CustomerDTOList(customerService.getAllCustomer());
        return new ResponseEntity<CustomerDTOList>(customers, HttpStatus.OK);
    }

    //    add new customer
    @PostMapping("/customers")
    public ResponseEntity<?> addCustomer (@RequestBody CustomerDTO newCustomer) {
        CustomerDTO result = customerService.addCustomer(newCustomer);
        return new ResponseEntity<CustomerDTO>(result, HttpStatus.CREATED);
    }

    //    remove a customer
    @DeleteMapping("/customers/{customerNumber}")
    public ResponseEntity<?> removeCustomer (@PathVariable long customerNumber) {
        CustomerDTO customer = customerService.getOneCustomer(customerNumber);
        if (customer == null) {
            return new ResponseEntity<String>(
                    "Customer with number " + customerNumber + " is not available",
                    HttpStatus.NOT_FOUND);
        }
        customerService.removeCustomer(customerNumber);
        return new ResponseEntity<String>(
                "Removed customer with number " + customerNumber + " successfully",
                HttpStatus.NO_CONTENT);
    }

    //    update a customer
    @PutMapping("/customers/{customerNumber}")
    public ResponseEntity<?> updateCustomer (
            @PathVariable long customerNumber,
            @RequestBody CustomerDTO customer) {

        CustomerDTO curCustomer = customerService.updateCustomer(customerNumber,customer);
        if(curCustomer == null) {
            return new ResponseEntity<String>(
                    "Customer with number " + customerNumber + " is not available",
            HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CustomerDTO>(curCustomer, HttpStatus.OK);
    }

    //    search customer
    @GetMapping("/customers/search")
    public ResponseEntity<?> searchCar (
            @RequestParam(value = "name", required = false, defaultValue = "") String name,
            @RequestParam(value = "email", required = false, defaultValue = "") String email) {

        CustomerDTOList customers = new CustomerDTOList();
        customers.setCustomers(customerService.searchCustomer(name.equals("") ? null : name, email.equals("") ? null : email));
        if (customers == null) {
            return new ResponseEntity<String>(
                    "Not found",
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CustomerDTOList>(customers, HttpStatus.FOUND);
    }

    @PostMapping("/customers/cars")
    public ResponseEntity<?> rentCar (
            @RequestParam (value = "brand", required = false) String brand,
            @RequestParam (value = "type", required = false) String type,
            @RequestParam (value = "customerId", required = false) long customerId,
            @RequestParam (value = "fromDate", required = false) String fromDate,
            @RequestParam (value = "toDate", required = false) String toDate,
            @RequestParam (value = "location", required = false) String location,
            @RequestParam (value = "operation", required = false) String operation) {
        if (operation.equals("reserve")) {
            Date from = DateService.formatDate(fromDate);
            Date to = DateService.formatDate(toDate);

            RentalDTO rentalDTO = customerService.reservedCar(brand, type, customerId, from, to, location);
            return new ResponseEntity<RentalDTO>(rentalDTO, HttpStatus.OK);
        } else {
            RentalDTOList rentalDTOList = new RentalDTOList();
            if (operation.equals("rent")) {
                List<RentalDTO> rentalDTOs = customerService.rentCar(customerId);
                rentalDTOList.setRentalDTOList(rentalDTOs);
            }
            if (operation.equals("payment")) {
                List<RentalDTO> rentalDTOs = customerService.payForRent(customerId);
                rentalDTOList.setRentalDTOList(rentalDTOs);
            }
            return new ResponseEntity<RentalDTOList>(rentalDTOList,HttpStatus.OK);
        }

    }

//    @GetMapping("/customers/history/customers/{customerNumber}")
//    public ResponseEntity<?> getCustomerHistory (@PathVariable long customerNumber) {
//        HistoryDTOList history = new HistoryDTOList(historyService.getAllHistoryByCustomer(customerNumber));
//        if (history == null) {
//            return new ResponseEntity<String>(
//                    "History of customer with number " + customerNumber + " is not available",
//                    HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<HistoryDTOList>(history, HttpStatus.OK);
//    }
//
//    @GetMapping("/customers/history/cars/{licensePlate}")
//    public ResponseEntity<?> getCarHistory (@PathVariable String licensePlate) {
//        HistoryDTOList history = new HistoryDTOList(historyService.getAllHistoryByCar(licensePlate));
//        if (history == null) {
//            return new ResponseEntity<String>(
//                    "History of car with license plate " + licensePlate + " is not available",
//                    HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<HistoryDTOList>(history, HttpStatus.OK);
//    }
}
