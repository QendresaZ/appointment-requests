package com.example.appointmentrequestschallange.repository;

import com.example.appointmentrequestschallange.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
