package com.ssa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.ssa.entity.Review;
import com.ssa.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
	private final ReviewService service;

	@PostMapping
	public Review addReview(@RequestBody Review review) {
		return service.save(review);
	}

	@GetMapping("/{targetId}")
	public List<Review> getReviews(@PathVariable Long targetId) {
		return service.getReviews(targetId);
	}

	@DeleteMapping("/{reviewId}")
	public void deleteReview(@PathVariable Long reviewId) {
		service.delete(reviewId);
	}
}
