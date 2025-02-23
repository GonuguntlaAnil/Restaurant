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

import com.anil.model.Order;
import com.anil.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderservice;
	
	@GetMapping
    public List<Order> getAllOrders() {
        return orderservice.getAllOrders();
    }

    
    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable Long id) {
        return orderservice.getOrderById(id);
    }

    
    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomerId(@PathVariable Long customerId) {
        return orderservice.getOrdersByCustomerId(customerId);
    }

    
    @GetMapping("/restaurant/{restaurantId}")
    public List<Order> getOrdersByRestaurantId(@PathVariable Long restaurantId) {
        return orderservice.getOrdersByRestaurantId(restaurantId);
    }

    
    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order) {
        return orderservice.addOrder(order);
    }

    
    @PutMapping("update//{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return orderservice.updateOrder(id, order);
    }

    // Delete an order
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderservice.deleteOrder(id);
    }

}
