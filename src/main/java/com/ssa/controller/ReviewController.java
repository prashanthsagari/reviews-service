package com.ssa.controller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.client.WebClient;

import com.ssa.entity.Review;
import com.ssa.external.Favorite;
import com.ssa.service.ReviewService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
	private final ReviewService service;

	private final WebClient.Builder webClientBuilder;

	@GetMapping("/favorites/{userId}")
	public ResponseEntity<List<Favorite>> getFavorites(@PathVariable Long userId) {
		ParameterizedTypeReference<List<Favorite>> responseType = new ParameterizedTypeReference<>() {
		};

		return webClientBuilder.build().get().uri("http://favorites-service:9000" + "/favorites/{userId}", userId)
		        .retrieve().toEntity(responseType).block();
	}

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
