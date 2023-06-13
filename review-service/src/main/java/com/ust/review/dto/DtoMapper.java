package com.ust.review.dto;

import com.ust.review.domain.Appointment;
import com.ust.review.domain.Review;
import com.ust.review.service.AppointmentServiceImpl;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DtoMapper {

    AppointmentServiceImpl appointmentService;

    public DtoMapper(AppointmentServiceImpl appointmentService) {
        this.appointmentService = appointmentService;
    }

    public Review createReview(RequestDto requestDto){
       List<Appointment> appointmentList=appointmentService.findAppointmentByDocIdAndUsId
                (requestDto.getDoctorId(),requestDto.getDoctorId());
        if(appointmentList.isEmpty()){
            throw new RuntimeException();
        }
        else {
            Review review=new Review();
            review.setDoctorId(requestDto.getDoctorId());
            review.setUserId(requestDto.getUserId());
            review.setRating(requestDto.getRating());
            review.setDescription(requestDto.getDescription());
            return review;
        }

    }

    public ReviewDto convertToDto(Review review){
        return new ReviewDto(
                review.getReviewId(),
                review.getUserId(),
                review.getDoctorId(),
                review.getRating(),
                review.getDescription()
        );
    }

    public Review convertToEntity(ReviewDto reviewDto){
        return new Review(
                reviewDto.reviewId(),
                reviewDto.userId(),
                reviewDto.doctorId(),
                reviewDto.rating(),
                reviewDto.description()
        );
    }
}
