package com.ust.review.service;

import com.ust.review.domain.Appointment;

import java.util.Optional;

public interface AppointmentService {
    Optional<Appointment> findAppointmentByUsIdAndDocId(Long doctorId, Long appointmentId);
}
