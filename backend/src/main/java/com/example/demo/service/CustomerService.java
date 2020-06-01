package com.example.demo.service;

import com.example.demo.models.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Optional<Customer> getCustomerById(String customerId) {
        return this.customerRepository.findById(customerId);
    }

    public Customer save(Customer customer) {
        return this.customerRepository.save(customer);
    }
}
