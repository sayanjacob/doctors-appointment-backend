package com.ust.review.service;

import com.ust.review.domain.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Review addReview(Review review);

    Optional<Review> viewReview(Long reviewId);

    List<Review> viewAllReviewForDoctor(Long doctorId);
}
