package com.springboot.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.demo.entity.WeightEntry;
import com.springboot.demo.repository.WeightEntryRepository;
import java.util.List;

@Service
public class WeightEntryService {

    @Autowired
    private WeightEntryRepository weightEntryRepository;

    public List<WeightEntry> getAllWeightEntries() {
        return weightEntryRepository.findAll();
    }

    public WeightEntry getWeightEntryById(Long id) {
        return weightEntryRepository.findById(id).orElse(null);
    }

    public WeightEntry createWeightEntry(WeightEntry weightEntry) {
        return weightEntryRepository.save(weightEntry);
    }

    public WeightEntry updateWeightEntry(Long id, WeightEntry updatedEntry) {
        WeightEntry existingEntry = weightEntryRepository.findById(id).orElse(null);
        if (existingEntry != null) {
            existingEntry.setWeight(updatedEntry.getWeight());
            existingEntry.setHeight(updatedEntry.getHeight());
            existingEntry.setDate(updatedEntry.getDate());
            return weightEntryRepository.save(existingEntry);
        }
        return null;
    }

    public void deleteWeightEntry(Long id) {
        weightEntryRepository.deleteById(id);
    }
}
