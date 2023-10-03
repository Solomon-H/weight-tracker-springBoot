package com.springboot.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.demo.entity.HealthyFood;

public interface HealthyFoodRepository extends JpaRepository<HealthyFood, Long> {

   Optional<HealthyFood> getHealthyFoodById(Long id);
}