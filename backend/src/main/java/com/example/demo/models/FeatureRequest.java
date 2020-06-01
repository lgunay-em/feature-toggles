package com.example.demo.models;

import java.util.ArrayList;

public class FeatureRequest {

    private String customerId;
    private Iterable<FeatureDTO> features = new ArrayList<FeatureDTO>();

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Iterable<FeatureDTO> getFeatures() {
        return features;
    }

    public void setFeatures(Iterable<FeatureDTO> features) {
        this.features = features;
    }
}
