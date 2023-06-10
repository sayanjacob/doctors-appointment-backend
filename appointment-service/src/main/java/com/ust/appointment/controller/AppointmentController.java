package com.ust.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.appointment.entity.AppointmentEntity;

@RestController
@RequestMapping("/appnt")
public class AppointmentController {
	@Autowired
	
	private AppointmentService serv;
	@PostMapping
	public ResponseEntity<AppointmentEntity> create(@RequestBody  )
	

}
