package com.ssa.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "favorites-service", url = "http://localhost:9000")
public interface FavoritesServiceClient {
	
	@GetMapping("/favorites/{userId}")
	public ResponseEntity<List<Favorite>> getFavorites(@PathVariable Long userId);

}
