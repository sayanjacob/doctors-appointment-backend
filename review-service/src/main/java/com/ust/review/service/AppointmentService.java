package com.ust.review.service;

import com.ust.review.domain.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> findAppointmentByDocIdAndUsId(Long doctorId, Long appointmentId);
}
