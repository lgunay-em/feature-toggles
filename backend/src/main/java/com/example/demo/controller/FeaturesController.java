package com.example.demo.controller;

import com.example.demo.models.*;
import com.example.demo.service.CustomerService;
import com.example.demo.service.FeatureToggleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
public class FeaturesController {

    @Autowired
    private FeatureToggleService featureToggleService;

    @Autowired
    private CustomerService customerService;

    @ResponseBody
    @PostMapping("/api/v1/features/assign")
    FeatureResponse featureRequest(@RequestBody FeatureRequest featureRequest) {
        Customer customer = new Customer();

        // find existing customer
        if (featureRequest.getCustomerId() != null) {
            Optional<Customer> customerOpt = this.customerService.getCustomerById(featureRequest.getCustomerId());
            if (customerOpt.isPresent()) {
                customer = customerOpt.get();
            } else {
                customer.setId(featureRequest.getCustomerId());
            }
        }

        FeatureResponse response = new FeatureResponse();
        for (FeatureDTO feature: featureRequest.getFeatures()) {
            Optional<FeatureToggle> featureToggle = this.featureToggleService.getByTechnicalName(feature.getName());
            if (featureToggle.isPresent()) {
                // assign to customer
                featureToggle.get().getCustomers().add(customer);
                this.featureToggleService.save(featureToggle.get());

                // prepare response
                response.getFeatures().add(FeatureDTO.byFeatureToggle(featureToggle.get()));
            }
        }
        return response;
    }

    @ResponseBody
    @GetMapping("/api/v1/features/byCustomer/{customerId}")
    FeatureResponse featuresByCustomer(@PathVariable String customerId) {
        Optional<Customer> customer = this.customerService.getCustomerById(customerId);
        FeatureResponse featureResponse = new FeatureResponse();
        if (customer.isPresent()) {
            for (FeatureToggle featureToggle: customer.get().getFeatures()) {
                featureResponse.getFeatures().add(FeatureDTO.byFeatureToggle(featureToggle));
            }
        }
        return featureResponse;
    }

}
