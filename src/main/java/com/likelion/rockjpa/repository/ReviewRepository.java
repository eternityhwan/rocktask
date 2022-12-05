package com.likelion.rockjpa.repository;

import com.likelion.rockjpa.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
