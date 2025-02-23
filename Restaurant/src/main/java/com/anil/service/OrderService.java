package com.anil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.Repository.OrderRepository;
import com.anil.model.Order;

@Service
public class OrderService {
	
	
	@Autowired
	private OrderRepository orderrepo;
	
	public List<Order>getAllOrders(){
		return orderrepo.findAll();
	}
	
	public Optional<Order> getOrderById(Long id) {
        return orderrepo.findById(id);
    }
	   public List<Order> getOrdersByCustomerId(Long customerId) {
	        return orderrepo.findByCustomerId(customerId);
	    }

	    
	    public List<Order> getOrdersByRestaurantId(Long restaurantId) {
	        return orderrepo.findByRestaurantId(restaurantId);
	    }
	    public Order addOrder(Order order) {
	        return orderrepo.save(order);
	    }

	  
	    public Order updateOrder(Long id, Order newOrder) {
	        return orderrepo.findById(id).map(order -> {
	            order.setStatus(newOrder.getStatus());
	            order.setTotalAmount(newOrder.getTotalAmount());
	            // Optionally update customer or restaurant if needed
	            return orderrepo.save(order);
	        }).orElseThrow(() -> new RuntimeException("Order not found"));
	    }

	   
	    public void deleteOrder(Long id) {
	        orderrepo.deleteById(id);
	    }

	
	
	

}
