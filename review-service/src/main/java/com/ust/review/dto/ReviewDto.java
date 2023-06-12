package com.ust.review.dto;

public record ReviewDto(
        Long reviewId,
        Long userId,
        Long doctorId,
        int rating,
        String description) {
}
