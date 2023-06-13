package com.ust.review.dto;

import com.ust.review.domain.Appointment;
import com.ust.review.domain.Review;
import com.ust.review.service.AppointmentServiceImpl;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class DtoMapper {

    AppointmentServiceImpl appointmentService;

    public DtoMapper(AppointmentServiceImpl appointmentService) {
        this.appointmentService = appointmentService;
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
