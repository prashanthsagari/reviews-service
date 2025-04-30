package com.ssa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    @Id
    private Long id;

    @Column(name = "reviewer_id")
    private Long reviewerId;

    @Column(name = "target_type")
    private String targetType; // flat, flatmate, landlord

    @Column(name = "target_id")
    private Long targetId;

    @Column(name = "comments", columnDefinition = "CLOB")
    private String comments;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
