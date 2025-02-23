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

import com.anil.model.Restaurant;
import com.anil.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	  @Autowired
	    private RestaurantService restaurantService;
	  
	    @GetMapping
	    public List<Restaurant> getAllRestaurants() {
	        return restaurantService.getAllRestaurants();
	    }

	    @GetMapping("/{id}")
	    public Optional<Restaurant> getRestaurantById(@PathVariable Long id) {
	        return restaurantService.getRestaurantById(id);
	    }

	   
	    @GetMapping("/foodType/{foodType}")
	    public List<Restaurant> getRestaurantsByFoodType(@PathVariable String foodType) {
	        return restaurantService.getRestaurantsByFoodType(foodType);
	    }

	  
	    @PostMapping
	    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
	        return restaurantService.addRestaurant(restaurant);
	    }

	  
	    @PutMapping("/{id}")
	    public Restaurant updateRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant) {
	        return restaurantService.updateRestaurant(id, restaurant);
	    }

	   
	    @DeleteMapping("/{id}")
	    public void deleteRestaurant(@PathVariable Long id) {
	        restaurantService.deleteRestaurant(id);
	    }
	
	

}
