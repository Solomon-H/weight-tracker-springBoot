package com.springboot.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.demo.entity.WeightEntry;

public interface WeightEntryRepository extends JpaRepository<WeightEntry, Long> {

    public Optional <WeightEntry> getEntryById(Long id);
    
}
