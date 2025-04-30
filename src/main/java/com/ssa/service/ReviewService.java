package com.ssa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.ssa.entity.Review;
import com.ssa.repository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
	private final ReviewRepository repository;

	public Review save(Review review) {
		return repository.save(review);
	}

	public List<Review> getReviews(Long targetId) {
		return repository.findByTargetId(targetId);
	}

	public void delete(Long reviewId) {
		repository.deleteById(reviewId);
	}
}
