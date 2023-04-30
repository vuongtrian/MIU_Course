package miu.edu.CarRental.controller;

import miu.edu.CarRental.service.IHistoryService;
import miu.edu.CarRental.service.dto.HistoryDTOList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoryController {

    @Autowired
    private IHistoryService historyService;

    @GetMapping("/history/customers/{customerNumber}")
    public ResponseEntity<?> getCustomerHistory (@PathVariable long customerNumber) {
        HistoryDTOList history = new HistoryDTOList(historyService.getAllHistoryByCustomer(customerNumber));
        if (history == null) {
            return new ResponseEntity<String>(
                    "History of customer with number " + customerNumber + " is not available",
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<HistoryDTOList>(history, HttpStatus.OK);
    }

    @GetMapping("/history/cars/{licensePlate}")
    public ResponseEntity<?> getCarHistory (@PathVariable String licensePlate) {
        HistoryDTOList history = new HistoryDTOList(historyService.getAllHistoryByCar(licensePlate));
        if (history == null) {
            return new ResponseEntity<String>(
                    "History of car with license plate " + licensePlate + " is not available",
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<HistoryDTOList>(history, HttpStatus.OK);
    }
}
