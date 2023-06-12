package com.ust.appointment.service;

import java.util.List;

import com.ust.appointment.entity.Appointment;
import com.ust.appointment.entity.Doctor;

public interface AppointmentService {


	Appointment createAppointment(Appointment appointment);

	List<Appointment> viewAllAppointmentsByUser(Long userId);

	void deleteAppointment(Long appointmentId);

}
