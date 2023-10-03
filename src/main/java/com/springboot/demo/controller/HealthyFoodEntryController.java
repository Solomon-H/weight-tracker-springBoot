package com.springboot.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import com.springboot.demo.entity.HealthyFood;
import com.springboot.demo.service.HealthyFoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/healthy-food")
public class HealthyFoodEntryController {

    @Autowired
    private HealthyFoodService healthyFoodService;

    public HealthyFoodEntryController(HealthyFoodService healthyFoodService) {
        this.healthyFoodService = healthyFoodService;
    }

    @GetMapping("/all")
    public List<HealthyFood> getAllHealthyFoodEntries() {
        return healthyFoodService.getAllHealthyFoodEntries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthyFood> getHealthyFoodEntryById(@PathVariable Long id) {
        HealthyFood entry = healthyFoodService.getHealthyFoodEntryById(id);
        if (entry != null) {
            return ResponseEntity.ok(entry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public String createHealthyFoodEntry(@RequestBody HealthyFood healthyFoodEntry) {
        healthyFoodService.createHealthyFoodEntry(healthyFoodEntry);
        return "Created!";
    }

    @PutMapping("/{id}")
    public ResponseEntity<HealthyFood> updateHealthyFoodEntry(@PathVariable Long id, @RequestBody HealthyFood updatedEntry) {
        HealthyFood updated = healthyFoodService.updateHealthyFoodEntry(id, updatedEntry);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public String deleteHealthyFood(@PathVariable Long id) {
        healthyFoodService.deleteHealthyFood(id);
        return "Deleted";
    }

}
