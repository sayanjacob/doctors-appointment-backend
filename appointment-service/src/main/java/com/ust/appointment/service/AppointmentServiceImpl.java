package com.ust.appointment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ust.appointment.entity.AppointmentEntity;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	
	@Override
	public AppointmentEntity createAppointment(AppointmentEntity appointmentEntity) {
		
		return null;
	}

	@Override
	public List<AppointmentEntity> viewAllAppointmentsByUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAppointment(Long appointmentId) {
		// TODO Auto-generated method stub
		
	}

}
