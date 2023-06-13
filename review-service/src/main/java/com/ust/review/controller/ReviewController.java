package com.ust.review.controller;


import com.ust.review.domain.Review;
import com.ust.review.dto.DtoMapper;
import com.ust.review.dto.RequestDto;
import com.ust.review.dto.ReviewDto;
import com.ust.review.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    ReviewService reviewService;
    DtoMapper dtoMapper;

    public ReviewController(ReviewService reviewService, DtoMapper dtoMapper) {
        this.reviewService = reviewService;
        this.dtoMapper = dtoMapper;
    }

    @PutMapping()
    public ResponseEntity<ReviewDto> createReview(@RequestBody RequestDto requestDto){
        Review review=dtoMapper.createReview(requestDto);
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
