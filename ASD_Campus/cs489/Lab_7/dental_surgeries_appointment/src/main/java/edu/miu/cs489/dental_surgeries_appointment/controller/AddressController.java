package edu.miu.cs489.dental_surgeries_appointment.controller;

import edu.miu.cs489.dental_surgeries_appointment.dto.address.AddressResponse;
import edu.miu.cs489.dental_surgeries_appointment.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    // HTTP GET request: http://localhost:8080/adsweb/api/v1/address/list - Displays the list of all Addresses, including the Patient data, sorted in ascending order by their city, in JSON format.
    @GetMapping("/list")
    public ResponseEntity<List<AddressResponse>> getAllAddresses() {
        return ResponseEntity.ok(addressService.getAllAddress());
    }
}
