package com.example.appointmentrequestschallange.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String service;
    @Enumerated(EnumType.ORDINAL)
    private AppointmentState appointmentState;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate appointmentRequestDate;
}
