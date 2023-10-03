package com.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.springboot.demo.entity.WeightEntry;
import com.springboot.demo.service.WeightEntryService;
import java.util.List;


@RestController
@RequestMapping("/weight-entry")
public class WeightEntryController {

    @Autowired
    private WeightEntryService weightEntryService;

    public WeightEntryController(WeightEntryService weightEntryService) {
        this.weightEntryService = weightEntryService;
    }

     @PostMapping("/create")
    public String createWeightEntry(@RequestBody WeightEntry weightEntry) {
         weightEntryService.createWeightEntry(weightEntry);
         return "Created";
    }


    @GetMapping("/all")
    public List<WeightEntry> getAllWeightEntries() {
        return weightEntryService.getAllWeightEntries();
    }


    @GetMapping("/{id}")
    public ResponseEntity<WeightEntry> getWeightEntryById(@PathVariable Long id) {
        WeightEntry entry = weightEntryService.getWeightEntryById(id);
        if (entry != null) {
            return ResponseEntity.ok(entry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<WeightEntry> updateWeightEntry(@PathVariable Long id, @RequestBody WeightEntry updatedWeightEntry) {
        WeightEntry updatedEntry = weightEntryService.updateWeightEntry(id, updatedWeightEntry);
        if (updatedEntry != null) {
            return ResponseEntity.ok(updatedEntry);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/{id}/calculate")
    public ResponseEntity<String> calculateBMI(@PathVariable Long id) {
        WeightEntry weightEntry = weightEntryService.getWeightEntryById(id);
        if (weightEntry != null) {
            double weightInKg = weightEntry.getWeight();
            double heightInCm = Double.parseDouble(weightEntry.getHeight().replace("cm", ""));
            double heightInM = heightInCm / 100.0;

            double bmi = weightInKg / (heightInM * heightInM);

            return ResponseEntity.ok("BMI: " + bmi);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/{id}/custom-calculation")
    public ResponseEntity<String> customCalculation(@PathVariable Long id) {
        WeightEntry weightEntry = weightEntryService.getWeightEntryById(id);
        if (weightEntry != null) {
            double weightInKg = weightEntry.getWeight();
            double heightInCm = Double.parseDouble(weightEntry.getHeight().replace("cm", ""));

            double customResult = weightInKg * heightInCm;

            return ResponseEntity.ok("Custom Calculation Result is: " + customResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWeightEntry(@PathVariable Long id) {
        weightEntryService.deleteWeightEntry(id);
        return ResponseEntity.noContent().build();
        
    }

}




