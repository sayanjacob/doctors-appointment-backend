package com.ust.appointment.service;

import java.util.List;

import com.ust.appointment.entity.AppointmentEntity;
import com.ust.appointment.entity.Doctor;

public interface AppointmentService {


	AppointmentEntity createAppointment(AppointmentEntity appointmentEntity);

	List<AppointmentEntity> viewAllAppointmentsByUser(Long userId);

	void deleteAppointment(Long appointmentId);

	List<Doctor> findDoctorByDepartment(String department);
}
