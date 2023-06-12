package com.ust.admin.service;

import com.ust.admin.domain.Doctor;
import com.ust.admin.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private DoctorRepository doctorRepository;
    @Override
    public Doctor createDoctor(Doctor doctor) {

        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor) {
        Doctor doc =doctorRepository.findById(doctor.getDoctorId()).get();
        doc.setDoctorId(doctor.getDoctorId());
        doc.setDoctorName(doctor.getDoctorName());
        doc.setDepartment(doctor.getDepartment());
        return doctorRepository.save(doc);
    }

    @Override
    public void deleteDoctor(Doctor doctor) {
        doctorRepository.delete(doctor);
    }

    @Override
    public Optional<Doctor> findDoctor(String doctorName) {
        return doctorRepository.findByDoctorName(doctorName);
    }

    @Override
    public Optional<Doctor> findById(Long doctorId) {
       return doctorRepository.findById(doctorId);

    }

    @Override
    public List<Doctor> findByDept(String department) {
        return doctorRepository.findByDepartment(department);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
}
