package com.ust.appointment.controller;

import com.ust.appointment.dto.AppointmentDto;
import com.ust.appointment.dto.DtoMapper;
import com.ust.appointment.dto.RequestDto;
import com.ust.appointment.entity.Doctor;
import com.ust.appointment.service.AppointmentService;
import com.ust.appointment.service.DoctorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {


    private DoctorServiceImpl doctorServiceImpl;
    private AppointmentService appointmentService;
    private final DtoMapper dtoMapper;

    public AppointmentController(DoctorServiceImpl doctorServiceImpl, AppointmentService appointmentService, DtoMapper dtoMapper) {
        this.doctorServiceImpl = doctorServiceImpl;
        this.appointmentService = appointmentService;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<AppointmentDto> create(@RequestBody RequestDto requestDto) {
        AppointmentDto appointmentDto = dtoMapper.createAppointmentDto(requestDto);
        var request = dtoMapper.convertToEntity(appointmentDto);
        var response = dtoMapper.convertToDto(appointmentService.createAppointment(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<List<AppointmentDto>> appointmentsByUser(@PathVariable long userId) {
        var appointmentList = appointmentService.viewAllAppointmentsByUser(userId);
        List<AppointmentDto> appointmentDtoList = appointmentList.stream()
                .map(appointment -> dtoMapper.convertToDto(appointment))
                .toList();
        return ResponseEntity.status(HttpStatus.FOUND).body(appointmentDtoList);

    }
}

	


