package com.ust.admin.controller;

import com.ust.admin.domain.Doctor;
import com.ust.admin.dto.DoctorDto;
import com.ust.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
    public Doctor convertToEntity(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(doctorDto.doctorId());
        doctor.setDoctorName(doctorDto.doctorName());
        doctor.setDepartment(doctorDto.department());
        return doctor;
    }

    public DoctorDto convertToDto(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto(doctor.getDoctorId(), doctor.getDoctorName(), doctor.getDepartment());
        return doctorDto;
    }

    @Autowired
    AdminService adminService;

    @PostMapping("")
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto) {
        final var doc = convertToEntity(doctorDto);
        adminService.createDoctor(doc);
        DoctorDto doctorDto1 = convertToDto(doc);
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorDto1);
    }

    @PutMapping("")
    public ResponseEntity<DoctorDto> updateDoctor(@RequestBody DoctorDto doctorDto) {
        final var doc = convertToEntity(doctorDto);
        if (adminService.findById(doc.getDoctorId()).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        final var docDto = convertToDto(adminService.updateDoctor(doc));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(docDto);
    }

    @GetMapping("/{name}")
    public ResponseEntity<DoctorDto> searchDoctorByName(@PathVariable String name) {
        Optional<Doctor> doc = adminService.findDoctor(name);
        if (doc.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        final var docDto = convertToDto(doc.get());
        return ResponseEntity.status(HttpStatus.FOUND).body(docDto);
    }

    @DeleteMapping("")
    public ResponseEntity<Void> deleteDoctor(@RequestBody DoctorDto doctorDto) {
        final var doc = convertToEntity(doctorDto);
        if (adminService.findById(doc.getDoctorId()).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        adminService.deleteDoctor(doc);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping("/search")
    public ResponseEntity<List<DoctorDto>> searchDoctors(@RequestParam("department") String department) {

        List<Doctor> doctorList = adminService.findByDept(department);
        List<DoctorDto> doctorDtoList = doctorList.stream()
                .map(doctor -> convertToDto(doctor))
                .toList();
        return ResponseEntity.status(HttpStatus.FOUND).body(doctorDtoList);

    }

    @GetMapping("/id")
    public  ResponseEntity<Doctor> findDoctorById(@PathVariable int id){
        return  ResponseEntity.status(HttpStatus.FOUND).body(adminService.findById(id).get());
    }
}
