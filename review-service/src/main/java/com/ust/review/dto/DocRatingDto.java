package com.ust.review.dto;

import com.ust.review.domain.Review;

import java.util.List;

public record DocRatingDto (
        Long doctorId,
        String doctorName,
        String department,
        int avRating,
        List<Review> reviewList){

}
