package com.ust.admin.repository;

import com.ust.admin.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    public Optional<Doctor> findByDoctorName(String doctorName);

    public List<Doctor> findByDepartment(String department);

}
