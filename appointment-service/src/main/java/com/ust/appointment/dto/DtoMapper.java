package com.ust.appointment.dto;

import com.ust.appointment.entity.Appointment;
import com.ust.appointment.entity.Doctor;
import com.ust.appointment.service.DoctorServiceImpl;
import org.springframework.stereotype.Component;
@Component
public class DtoMapper {
    DoctorServiceImpl doctorServiceImpl;
    public DtoMapper(DoctorServiceImpl doctorServiceImpl) {
        this.doctorServiceImpl = doctorServiceImpl;
    }
    public AppointmentDto createAppointmentDto(RequestDto requestDto){
        Doctor doc=doctorServiceImpl.findById(requestDto.doctorId());

        return new AppointmentDto(
        requestDto.appointmentId(),
        requestDto.userId(),
        requestDto.appointmentDate(),
        requestDto.appointTime(),
        requestDto.doctorId(),
        doc.getDoctorName(),
        doc.getDepartment(),
        requestDto.userName(),
        requestDto.details());

    }
    public Appointment convertToEntity(AppointmentDto appointmentDto){
        Appointment appointment=new Appointment();


        appointment.setAppointmentId(appointmentDto.appointmentId());
        appointment.setUserId(appointmentDto.userId());
        appointment.setAppointTime(appointmentDto.appointTime());
        appointment.setAppointmentDate(appointmentDto.appointmentDate());
        appointment.setDepartment(appointmentDto.department());
        appointment.setDetails(appointmentDto.details());
        appointment.setUserName(appointmentDto.userName());
        appointment.setDoctorId(appointmentDto.doctorId());
        appointment.setDoctorName(appointmentDto.doctorName());
        return  appointment;


    }


    public AppointmentDto convertToDto(Appointment appointment){

        return new AppointmentDto(
                appointment.getAppointmentId(),
                appointment.getUserId(),
                appointment.getAppointmentDate(),
                appointment.getAppointTime(),
                appointment.getDoctorId(),
                appointment.getDoctorName(),
                appointment.getDepartment(),
                appointment.getUserName(),
                appointment.getDetails());
    }

}
