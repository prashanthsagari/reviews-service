package com.ssa.external;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews-favorites")
public class FavoritesController {

	private final FavoritesServiceClient favoritesServiceClient;
	
	public FavoritesController(FavoritesServiceClient favoritesServiceClient) {
		this.favoritesServiceClient = favoritesServiceClient;
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<Favorite>> getFavorites(@PathVariable Long userId) {
		return favoritesServiceClient.getFavorites(userId);
	}
}
