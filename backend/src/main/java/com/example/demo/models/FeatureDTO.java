package com.example.demo.models;

import java.util.Date;

public class FeatureDTO {

    private String name;
    private Boolean active = true;
    private Boolean inverted = false;
    private Boolean expired = false;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getInverted() {
        return inverted;
    }

    public void setInverted(Boolean inverted) {
        this.inverted = inverted;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    public static FeatureDTO byFeatureToggle(FeatureToggle featureToggle) {
        FeatureDTO feature = new FeatureDTO();
        feature.setName(featureToggle.getTechnicalName());
        feature.setActive(!featureToggle.getArchived());
        feature.setInverted(featureToggle.getInverted());
        if (featureToggle.getExpiresOn() != null) {
            feature.setExpired(featureToggle.getExpiresOn().before(new Date()));
        }
        return feature;
    }
}
