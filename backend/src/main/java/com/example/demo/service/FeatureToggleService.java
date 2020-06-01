package com.example.demo.service;

import com.example.demo.models.FeatureToggle;
import com.example.demo.repository.FeatureToggleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeatureToggleService {

    @Autowired
    private FeatureToggleRepository featureToggleRepository;

    public Optional<FeatureToggle> getByTechnicalName(String technicalName) {
        return this.featureToggleRepository.findByTechnicalName(technicalName);
    }

    public FeatureToggle save(FeatureToggle featureToggle) {
        return this.featureToggleRepository.save(featureToggle);
    }
}
