package com.ust.review.service;

import com.ust.review.domain.Review;
import com.ust.review.exception.ReviewAlreadyExistException;
import com.ust.review.exception.ReviewNotFoundException;
import com.ust.review.repo.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService{

    ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review addReview(Review review) throws ReviewAlreadyExistException {
        var req=viewByuserIdAndDoctorId(review.getUserId(),review.getDoctorId());
        if(req.isEmpty()) {
            return reviewRepository.save(review);
        }
        else
            throw new ReviewAlreadyExistException("Review Already Exist");
    }

    @Override
    public Optional<Review> viewReview(long reviewId) throws ReviewNotFoundException {
        var req = reviewRepository.findById(reviewId);
        if (req.isPresent()) {
            return req;
        } else
            throw new ReviewNotFoundException("Review Not Found");
    }




        @Override
        public List<Review> viewAllReviewForDoctor(long doctorId) throws ReviewNotFoundException {
            var req = reviewRepository.findAllByDoctorId(doctorId);
            if (req.isEmpty()) {
                throw new ReviewNotFoundException("Reviews not found");
            } else {
                return reviewRepository.findAllByDoctorId(doctorId);
            }
        }

    @Override
    public List<Review> viewAllReviewByUser(long userId) throws ReviewNotFoundException {
        var req=reviewRepository.findReviewsByUserId(userId);
        if(req.isEmpty()){
            throw new ReviewNotFoundException("Reviews Not found for user");
        }
        else {
            return req;
        }

    }

    @Override
    public Optional<Review> viewByuserIdAndDoctorId(long userId, long doctorId) {
        return reviewRepository.findReviewByUserIdAndDoctorId(userId,doctorId);
    }
}
