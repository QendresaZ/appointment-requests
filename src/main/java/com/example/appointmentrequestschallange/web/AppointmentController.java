package com.example.appointmentrequestschallange.web;

import com.example.appointmentrequestschallange.model.Appointment;
import com.example.appointmentrequestschallange.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping()
    public ResponseEntity<Appointment> makeAppointmentRequest(@RequestBody Appointment appointment) {
        Appointment savedAppointment = appointmentService.makeAppointmentRequest(appointment);
        return new ResponseEntity<>(savedAppointment, HttpStatus.CREATED);
    }

    @PatchMapping("/accept/{id}")
    public ResponseEntity<Appointment> acceptAppointmentRequest(@RequestBody Appointment appointment, @PathVariable Long id) {
        Appointment acceptedAppointment = appointmentService.acceptAppointmentRequest(appointment, id);
        return new ResponseEntity<>(acceptedAppointment, HttpStatus.ACCEPTED);
    }

    @PatchMapping("/reject/{id}")
    public ResponseEntity<Appointment> rejectAppointment(@RequestBody Appointment appointment, @PathVariable Long id) {
        Appointment rejectedAppointment = appointmentService.rejectAppointmentRequest(appointment, id);
        return new ResponseEntity<>(rejectedAppointment, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        List<Appointment> appointments = appointmentService.fetchAll();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
}
