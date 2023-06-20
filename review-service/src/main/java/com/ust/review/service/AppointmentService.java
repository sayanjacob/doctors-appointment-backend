package com.ust.review.service;

import com.ust.review.domain.Appointment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface AppointmentService {
    Optional<Appointment> findAppointmentByUsIdAndDocId(Long doctorId, Long appointmentId);


}
