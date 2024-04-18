package edu.miu.cs489.dental_surgeries_appointment.controller;

import edu.miu.cs489.dental_surgeries_appointment.dto.dentist.DentistRequest;
import edu.miu.cs489.dental_surgeries_appointment.dto.dentist.DentistResponse;
import edu.miu.cs489.dental_surgeries_appointment.service.DentistService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/dentist")
public class DentistController {
    @Autowired
    private DentistService dentistService;

    @GetMapping("/list")
    public ResponseEntity<List<DentistResponse>> getAllDentists() {
        return ResponseEntity.ok(dentistService.getAllDentists());
    }

    @GetMapping("/{dentistId}")
    public ResponseEntity<DentistResponse> getDentistById(@PathVariable Long dentistId) {
        return ResponseEntity.ok(dentistService.getDentist(dentistId));
    }

    @PostMapping("/register")
    public ResponseEntity<DentistResponse> registerDentist(@Valid @RequestBody DentistRequest dentist) {
        return new ResponseEntity<>(dentistService.createDentist(dentist), HttpStatus.CREATED);
    }

    @PutMapping("/update/{dentistId}")
    public ResponseEntity<DentistResponse> updateDentist(@PathVariable Long dentistId, @RequestBody DentistRequest dentist) {
        return new ResponseEntity<>(dentistService.updateDentist(dentistId, dentist), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{dentistId}")
    public ResponseEntity<?> deleteDentist(@PathVariable Long dentistId) {
        dentistService.deleteDentist(dentistId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
