package com.ust.review.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private long appointmentId;
    private long userId;
    private LocalDate appointmentDate;
    private LocalTime appointTime;
    private long doctorId;
    private String doctorName;
    private String department;
    private String userName;
    private String details;
}
