package com.example.demo.config;

import com.example.demo.models.Customer;
import com.example.demo.models.FeatureToggle;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(FeatureToggle.class);
        config.exposeIdsFor(Customer.class);
    }
}