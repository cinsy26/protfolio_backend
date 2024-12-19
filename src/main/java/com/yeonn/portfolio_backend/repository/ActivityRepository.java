package com.yeonn.portfolio_backend.repository;

import com.yeonn.portfolio_backend.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}