package com.ust.appointment.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Doctor {


    private Long doctorId;
    private String doctorName;
    private String department;


}
