package com.example.demo.models;

import java.util.List;
import java.util.ArrayList;

public class FeatureResponse {

    List<FeatureDTO> features = new ArrayList<FeatureDTO>();

    public FeatureResponse() {}

    public FeatureResponse(List<FeatureDTO> features) {
        this.setFeatures(features);
    }

    public List<FeatureDTO> getFeatures() {
        return this.features;
    }

    public void setFeatures(List<FeatureDTO> features) {
        this.features = features;
    }
}
