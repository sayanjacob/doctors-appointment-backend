package com.ust.admin.service;

import com.ust.admin.domain.Doctor;
import com.ust.admin.exception.DoctorAlreadyExistException;
import com.ust.admin.exception.DoctorNotFoundException;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    Doctor createDoctor(Doctor doctor);
    Doctor updateDoctor(Doctor doctor) throws DoctorNotFoundException;
    void deleteDoctor(Doctor doctor) throws DoctorNotFoundException;
    Optional<Doctor> findDoctor(String doctorName) throws DoctorNotFoundException;
    Optional<Doctor> findById(Long doctorId) throws DoctorNotFoundException;
    List<Doctor> findByDept(String department) throws DoctorNotFoundException;
    List<Doctor> findAll() throws DoctorNotFoundException;
}
