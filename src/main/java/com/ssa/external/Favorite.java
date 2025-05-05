package com.ssa.external;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Favorite {

	private Long id;

	private Long userId;

	private Long flatId;

	private LocalDateTime favoritedAt;

}