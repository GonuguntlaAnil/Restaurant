package com.anil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.Repository.CustomerRepository;
import com.anil.model.customer;

@Service
public class CustomerService {
	

    @Autowired
    private CustomerRepository customerRepository;

    public List<customer> getAllCustomers() {
        return customerRepository.findAll();
    }

 
    public Optional<customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public customer addCustomer(customer customer) {
        return customerRepository.save(customer);
    }


    public customer updateCustomer(Long id, customer newCustomer) {
        return customerRepository.findById(id).map(customer -> {
            customer.setName(newCustomer.getName());
            customer.setEmail(newCustomer.getEmail());
            return customerRepository.save(customer);
        }).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

   
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

}
