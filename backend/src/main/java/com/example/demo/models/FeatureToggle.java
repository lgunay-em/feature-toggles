package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class FeatureToggle {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = true)
    private String displayName;

    @Column(nullable = false, unique = true)
    private String technicalName;

    @Column(nullable = true)
    private Date expiresOn;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false)
    private Boolean inverted = false;

    @Column(nullable = false)
    private Boolean archived = false;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    private List<Customer> customers = new ArrayList<Customer>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTechnicalName() {
        return technicalName;
    }

    public void setTechnicalName(String technicalName) {
        this.technicalName = technicalName;
    }

    public Date getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(Date expiresOn) {
        this.expiresOn = expiresOn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getInverted() {
        return inverted;
    }

    public void setInverted(Boolean inverted) {
        this.inverted = inverted;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
