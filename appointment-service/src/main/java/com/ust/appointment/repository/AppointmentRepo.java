package com.ust.appointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.appointment.entity.AppointmentEntity;
@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentEntity, Long> {

}
