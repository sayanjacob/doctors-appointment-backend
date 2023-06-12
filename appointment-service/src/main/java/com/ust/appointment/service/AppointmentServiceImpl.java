package com.ust.appointment.service;

import java.util.List;
import java.util.Optional;

import com.ust.appointment.repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.appointment.entity.Appointment;
import org.springframework.web.client.RestTemplate;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private AppointmentRepo appointmentRepo;
	@Autowired
	private DoctorServiceImpl doctorService;


	@Override
	public Appointment createAppointment(Appointment appointment) {
		return appointmentRepo.save(appointment);
	}

	@Override
	public List<Appointment> viewAllAppointmentsByUser(Long userId) {
		return appointmentRepo.findAppointmentByUserId(userId);
	}

	@Override
	public void deleteAppointment(Long appointmentId) {
	appointmentRepo.deleteById(appointmentId);
	}

	@Override
	public Optional<Appointment> findByAppId(Long appointmentId) {
		return appointmentRepo.findById(appointmentId);
	}

	@Override
	public Optional<List<Appointment>> findByDocIdAndUserId(Long doctorId, Long userId) {
		return Optional.ofNullable(appointmentRepo.findAppointmentByUserIdAndDoctorId(doctorId, userId));
	}


}
