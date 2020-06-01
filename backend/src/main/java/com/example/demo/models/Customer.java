package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Customer {

    @Id
    private String id;

    @Column(nullable = true)
    private String name;

    @ManyToMany(mappedBy = "customers", fetch = FetchType.EAGER)
    private List<FeatureToggle> features = new ArrayList<FeatureToggle>();

    public Customer() {}
    public Customer(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<FeatureToggle> getFeatures() {
        return features;
    }

    public void setFeatures(List<FeatureToggle> features) {
        this.features = features;
    }
}
