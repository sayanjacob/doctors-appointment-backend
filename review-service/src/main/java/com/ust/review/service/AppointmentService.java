package com.ust.review.service;

import com.ust.review.domain.Appointment;

import java.util.Optional;

public interface AppointmentService {
    Optional<Appointment> findAppointmentByDocIdAndUsId(Long doctorId, Long appointmentId);
}
