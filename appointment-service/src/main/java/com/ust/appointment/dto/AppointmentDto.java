package com.ust.appointment.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentDto(
        long appointmentId,
        long userId,
        LocalDate appointmentDate,
        LocalTime appointTime,
        long doctorId,
        String doctorName,
        String department,
        String userName,
        String details) {


}
