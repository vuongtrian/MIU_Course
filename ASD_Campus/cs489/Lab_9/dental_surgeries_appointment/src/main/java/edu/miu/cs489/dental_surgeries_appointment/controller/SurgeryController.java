package edu.miu.cs489.dental_surgeries_appointment.controller;

import edu.miu.cs489.dental_surgeries_appointment.dto.surgery.SurgeryRequest;
import edu.miu.cs489.dental_surgeries_appointment.dto.surgery.SurgeryResponse;
import edu.miu.cs489.dental_surgeries_appointment.service.SurgeryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/surgery")
public class SurgeryController {
    @Autowired
    private SurgeryService surgeryService;

    @GetMapping("/list")
    public ResponseEntity<List<SurgeryResponse>> list() {
        return ResponseEntity.ok(surgeryService.getAllSurgery());
    }

    @GetMapping("/{surgeryId}")
    public ResponseEntity<SurgeryResponse> get(@PathVariable Long surgeryId) {
        return ResponseEntity.ok(surgeryService.getSurgery(surgeryId));
    }

    @PostMapping("/register")
    public ResponseEntity<SurgeryResponse> registerSurgery(@Valid @RequestBody SurgeryRequest surgeryRequest) {
        return new ResponseEntity<>(surgeryService.createSurgery(surgeryRequest), HttpStatus.CREATED);
    }

    @PutMapping("/update/{surgeryId}")
    public ResponseEntity<SurgeryResponse> updateSurgery(@PathVariable Long surgeryId, @RequestBody SurgeryRequest surgeryRequest) {
        return new ResponseEntity<>(surgeryService.updateSurgery(surgeryId,surgeryRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{surgeryId}")
    public ResponseEntity<SurgeryResponse> delete(@PathVariable Long surgeryId) {
        surgeryService.deleteSurgery(surgeryId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
