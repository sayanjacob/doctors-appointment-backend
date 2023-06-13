package com.ust.appointment.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record RequestDto(Long userId,
                         Long appointmentId,
                         Long doctorId,
                         String userName,
                         String details,
                         LocalDate appointmentDate,
                         LocalTime appointTime
) {
}
