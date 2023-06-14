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

    public ReviewController(ReviewService reviewService, DtoMapper dtoMapper, AppointmentService appointmentService) {
        this.reviewService = reviewService;
        this.dtoMapper = dtoMapper;
        this.appointmentService = appointmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<ReviewDto> createReview(@RequestBody RequestDto requestDto) {

        Optional<Appointment> appointment = appointmentService.findAppointmentByUsIdAndDocId(

                requestDto.getUserId(),
                requestDto.getDoctorId()
        );

        if (appointment.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        Review review = new Review();

        review.setDoctorId(requestDto.getDoctorId());
        review.setUserId(requestDto.getUserId());
        review.setRating(requestDto.getRating());
        review.setDescription(requestDto.getDescription());
        var request = reviewService.addReview(review);
        return ResponseEntity.status(HttpStatus.CREATED).body(dtoMapper.convertToDto(request));
    }


    @GetMapping("/{reviewId}")
    public ResponseEntity<ReviewDto> viewReview(@PathVariable long reviewId) {
        var req = reviewService.viewReview(reviewId);
        if (req.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }
        var response = dtoMapper.convertToDto(req.get());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<ReviewDto>> reviewForDoctor(@PathVariable long doctorId) {
        var response = reviewService.viewAllReviewForDoctor(doctorId);
        if (response.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }
        var res = response.stream().map(review -> dtoMapper.convertToDto(review)).toList();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReviewDto>> reviewForUser(@PathVariable long userId) {
        var response = reviewService.viewAllReviewByUser(userId);
        if (response.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }
        var res = response.stream().map(review -> dtoMapper.convertToDto(review)).toList();
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("/findreviews/{userId}/{doctorId}")
    public ResponseEntity<ReviewDto> reviewForDoctorByUser(@PathVariable long userId, @PathVariable long doctorId) {
        var response = reviewService.viewByuserIdAndDoctorId(userId, doctorId);
        if (response.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        var res =dtoMapper.convertToDto(response.get());
        return ResponseEntity.status(HttpStatus.OK).body(res);

    }
}
