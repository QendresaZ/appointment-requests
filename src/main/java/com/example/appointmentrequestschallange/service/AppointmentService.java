package com.example.appointmentrequestschallange.service;

import com.example.appointmentrequestschallange.model.Appointment;
import com.example.appointmentrequestschallange.model.AppointmentState;
import com.example.appointmentrequestschallange.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment makeAppointmentRequest(Appointment appointment) {
        appointment.setAppointmentState(AppointmentState.PENDING);
        return appointmentRepository.save(appointment);
    }

    public Appointment acceptAppointmentRequest(Appointment appointment, Long id) {
        Optional<Appointment> appointmentById = appointmentRepository.findById(id);
        appointmentById.get().setAppointmentState(AppointmentState.ACCEPTED);
        return appointmentRepository.save(appointmentById.get());
    }

    public Appointment rejectAppointmentRequest(Appointment appointment, Long id) {
        Optional<Appointment> appointmentById = appointmentRepository.findById(id);
        appointmentById.get().setAppointmentState(AppointmentState.REJECTED);
        return appointmentRepository.save(appointmentById.get());

    }

    public List<Appointment> fetchAll() {
       return appointmentRepository.findAll();
    }
}
