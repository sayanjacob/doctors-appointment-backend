package com.ust.appointment.service;

import java.util.Arrays;
import java.util.List;

import com.netflix.discovery.converters.Auto;
import com.ust.appointment.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.appointment.entity.AppointmentEntity;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Access;
import javax.print.Doc;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	private RestTemplate restTemplate;
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


	@Override
	public List<Doctor> findDoctorByDepartment(String department) {
		var response = restTemplate.getForEntity("http://localhost:8000/admin/search",
				Doctor[].class, department);
		if (response.hasBody()) {
			return Arrays.stream(response.getBody()).toList();
		}
		return List.of();
	}

}
