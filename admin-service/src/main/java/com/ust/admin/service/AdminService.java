package com.ust.admin.service;

import com.ust.admin.domain.Doctor;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    Doctor createDoctor(Doctor doctor);
    Doctor updateDoctor(Doctor doctor);
    void deleteDoctor(Doctor doctor);
    Optional<Doctor> findDoctor(String doctorName);
    Optional<Doctor> findById(Long doctorId);
    List<Doctor> findByDept(String department);
     List<Doctor> findAll();
}
