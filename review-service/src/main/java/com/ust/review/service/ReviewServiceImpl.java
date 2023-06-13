package com.ust.review.service;

import com.ust.review.domain.Review;
import com.ust.review.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    ReviewRepository reviewRepository;
    @Override
    public Review addReview(Review review) {

        return reviewRepository.save(review);
    }

    @Override
    public Optional<Review> viewReview(Long reviewId) {

        return reviewRepository.findById(reviewId);
    }

    @Override
    public List<Review> viewAllReviewForDoctor(Long doctorId) {

        return reviewRepository.findAllByDoctorId(doctorId);
    }
}
