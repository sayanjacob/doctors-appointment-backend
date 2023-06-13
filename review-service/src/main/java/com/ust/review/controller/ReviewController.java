package com.ust.review.controller;


import com.ust.review.domain.Appointment;
import com.ust.review.domain.Review;
import com.ust.review.dto.DtoMapper;
import com.ust.review.dto.RequestDto;
import com.ust.review.dto.ReviewDto;
import com.ust.review.service.AppointmentService;
import com.ust.review.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/review")
public class ReviewController {
    ReviewService reviewService;
    AppointmentService appointmentService;
    DtoMapper dtoMapper;

    public ReviewController(ReviewService reviewService, DtoMapper dtoMapper ,AppointmentService appointmentService) {
        this.reviewService = reviewService;
        this.dtoMapper = dtoMapper;
        this.appointmentService=appointmentService;
    }

    @PostMapping()
    public ResponseEntity<ReviewDto> createReview(@RequestBody RequestDto requestDto){

            Optional<Appointment> appointment = appointmentService.findAppointmentByDocIdAndUsId(
                    requestDto.getUserId(),
                    requestDto.getDoctorId()
            );
            Review review=new Review();

            if (appointment.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            review.setDoctorId(requestDto.getDoctorId());
            review.setUserId(requestDto.getUserId());
            review.setRating(requestDto.getRating());
            review.setDescription(requestDto.getDescription());
            var request=reviewService.addReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoMapper.convertToDto(request));
    }


    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewDto> viewReview(@PathVariable Long reviewId){
        var response=reviewService.viewReview(reviewId);
        return response.map(review -> ResponseEntity.status(HttpStatus.OK)
                .body(dtoMapper.convertToDto(review)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .build());
    }


    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<ReviewDto>> reviewForDoctor(@PathVariable Long doctorId){
        var response=reviewService.viewAllReviewForDoctor(doctorId);
        if(response.isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }
        var res=response.stream().map(review -> dtoMapper.convertToDto(review)).toList();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
