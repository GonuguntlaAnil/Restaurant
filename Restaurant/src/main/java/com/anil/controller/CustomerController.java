package com.anil.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anil.model.customer;
import com.anil.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
    private CustomerService customerService;


    @GetMapping
    public List<customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    
    @GetMapping("/{id}")
    public Optional<customer> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    
    @PostMapping
    public customer addCustomer(@RequestBody customer customer) {
        return customerService.addCustomer(customer);
    }


    @PutMapping("/{id}")
    public customer updateCustomer(@PathVariable Long id, @RequestBody customer customer) {
        return customerService.updateCustomer(id, customer);
    }

    
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

}
