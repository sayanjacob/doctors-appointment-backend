package com.ust.appointment.service;

import java.util.Arrays;
import java.util.List;

import com.ust.appointment.dto.AppointmentDto;
import com.ust.appointment.entity.Doctor;
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



}
