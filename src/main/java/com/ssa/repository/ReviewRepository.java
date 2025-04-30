package com.ssa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssa.entity.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByTargetId(Long targetId);
}
