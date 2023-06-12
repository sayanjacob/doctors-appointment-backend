package com.ust.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.appointment.entity.Appointment;

import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
    List<Appointment> findAppointmentByUserId(long id);
    List<Appointment> findAppointmentByUserIdAndDoctorId(Long userId,Long doctorId);

}
