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

    @GetMapping("/{doctorName}")
    public ResponseEntity<DoctorDto> searchDoctorByName(@PathVariable String doctorName) {
        Optional<Doctor> doc = adminService.findDoctor(doctorName);
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


    @GetMapping("/search/{department}")
    public ResponseEntity<List<DoctorDto>> searchDoctors(@PathVariable String department) {

        List<Doctor> doctorList = adminService.findByDept(department);
        List<DoctorDto> doctorDtoList = doctorList.stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.status(HttpStatus.FOUND).body(doctorDtoList);

    }

    @GetMapping("/find/{doctorId}")
    public  ResponseEntity<Doctor> findDoctorById(@PathVariable Long doctorId){
        var doc=adminService.findById(doctorId);
        if(doc.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return  ResponseEntity.status(HttpStatus.FOUND).body(doc.get());
    }
    @GetMapping("/findall")
    public  ResponseEntity<List<DoctorDto>> findAllDoctor(){
        List<DoctorDto> doctorDtoList =adminService.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(doctorDtoList);

    }
}
