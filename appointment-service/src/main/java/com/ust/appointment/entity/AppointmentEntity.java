package com.ust.appointment.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long appointmentId;
	private long userId;
	private LocalDate appointmentDate;
	private LocalTime appointTime;
	private long doctorid;
	private long doctorName;
	private long department;
	private String userName;
	private String details;

}
