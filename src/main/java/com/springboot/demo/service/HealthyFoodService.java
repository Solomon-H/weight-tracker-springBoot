package com.springboot.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.demo.entity.HealthyFood;
import com.springboot.demo.repository.HealthyFoodRepository;

@Service
public class HealthyFoodService {

    @Autowired
    private HealthyFoodRepository healthyFoodRepository;

    public List<HealthyFood> getAllHealthyFoodEntries() {
        return healthyFoodRepository.findAll();
    }

    public HealthyFood getHealthyFoodEntryById(Long id) {
        return healthyFoodRepository.findById(id).orElse(null);
    }

    public HealthyFood createHealthyFoodEntry(HealthyFood healthyFood) {
        return healthyFoodRepository.save(healthyFood);
    }

    public HealthyFood updateHealthyFoodEntry(Long id, HealthyFood updatedEntry) {
        HealthyFood existingEntry = healthyFoodRepository.findById(id).orElse(null);
        if (existingEntry != null) {
            existingEntry.setExercise(updatedEntry.getExercise());
            existingEntry.setMeal(updatedEntry.getMeal());
            existingEntry.setCalories(updatedEntry.getCalories());
            return healthyFoodRepository.save(existingEntry);
        }
        return null;
    }

    public void deleteHealthyFood(Long id) {
        healthyFoodRepository.deleteById(id);
    }
}
