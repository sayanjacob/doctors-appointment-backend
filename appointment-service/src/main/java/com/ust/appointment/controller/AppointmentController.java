package com.ust.appointment.controller;

import com.ust.appointment.dto.AppointmentDto;
import com.ust.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ust.appointment.entity.AppointmentEntity;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	@Autowired
	
	private AppointmentService appointmentService;
	@PostMapping("")
	public ResponseEntity<AppointmentEntity> create(@RequestBody AppointmentDto appointmentDto){
	return null;
	}

	

}
