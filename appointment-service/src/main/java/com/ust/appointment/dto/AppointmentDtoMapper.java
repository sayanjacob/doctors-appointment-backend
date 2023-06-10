package com.ust.appointment.dto;

import com.ust.appointment.entity.AppointmentEntity;
import org.springframework.stereotype.Component;

@Component
public class AppointmentDtoMapper {

    public AppointmentEntity convertToEntity(AppointmentDto appointmentDto){
        AppointmentEntity appointmentEntity=new AppointmentEntity();


        appointmentEntity.setAppointmentId(appointmentDto.appointmentId());
        appointmentEntity.setUserId(appointmentDto.userId());
        appointmentEntity.setAppointTime(appointmentDto.appointTime());
        appointmentEntity.setAppointmentDate(appointmentDto.appointmentDate());
        appointmentEntity.setDepartment(appointmentDto.department());
        appointmentEntity.setDetails(appointmentDto.details());
        appointmentEntity.setUserName(appointmentDto.userName());
        appointmentEntity.setDoctorid(appointmentDto.doctorId());
        appointmentEntity.setDoctorName(appointmentDto.doctorName());

    }


    public AppointmentDto convertToDto(AppointmentEntity appointmentEntity){
        AppointmentDto appointmentDto=new AppointmentDto(
                appointmentEntity.getAppointmentId(),
                appointmentEntity.getUserId(),
                appointmentEntity.getAppointmentDate(),
                appointmentEntity.getAppointTime(),
                appointmentEntity.getAppointmentId(),
                appointmentEntity.getDoctorName(),
                appointmentEntity.getDoctorid(),
                appointmentEntity.getUserName(),
                appointmentEntity.getDetails()
        );

        return appointmentDto;
    }

}
