package edu.miu.cs489.dental_surgeries_appointment.controller;

import edu.miu.cs489.dental_surgeries_appointment.dto.appointment.AppointmentResponse;
import edu.miu.cs489.dental_surgeries_appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/adsweb/api/v1/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/list")
    public ResponseEntity<List<AppointmentResponse>>  getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }
}
