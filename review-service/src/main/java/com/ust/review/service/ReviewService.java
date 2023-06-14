package com.ust.review.service;

import com.ust.review.domain.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    Review addReview(Review review);

    Optional<Review> viewReview(long reviewId);

    List<Review> viewAllReviewForDoctor(long doctorId);

    List<Review> viewAllReviewByUser(long userId);

    Optional<Review> viewByuserIdAndDoctorId(long userId,long doctorId);
}
