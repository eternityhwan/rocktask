package com.likelion.rockjpa.repository;

import com.likelion.rockjpa.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
