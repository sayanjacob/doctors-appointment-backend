package com.ust.appointment.service;

import java.util.List;
import java.util.Optional;

import com.ust.appointment.entity.Appointment;

public interface AppointmentService {


	Appointment createAppointment(Appointment appointment);

	List<Appointment> viewAllAppointmentsByUser(Long userId);

	void deleteAppointment(Long appointmentId);

	Optional<Appointment> findByAppId(Long appointmentId);
	Optional<List<Appointment>> findByDocIdAndUserId(Long DoctorId,Long userId);

}
