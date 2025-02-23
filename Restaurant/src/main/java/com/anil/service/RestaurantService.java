package com.anil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.Repository.RestaurantRepository;
import com.anil.model.Restaurant;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository repo;
	
	public List<Restaurant>getAllRestaurants(){
		return repo.findAll();
		
	}public Optional<Restaurant> getRestaurantById(Long id){
		return repo.findById(id);
		
	} public List<Restaurant> getRestaurantsByFoodType(String foodType) {
        return repo.findByFoodType(foodType); 
    }
	public  Restaurant addRestaurant(Restaurant add) {
    	return repo.save(add);
    }
	public void deleteRestaurant(Long id) {
    	 repo.deleteById(id);
    }
    public Restaurant updateRestaurant(Long id, Restaurant newRestaurant) {
        return repo.findById(id).map(restaurant -> {
            restaurant.setName(newRestaurant.getName());
            restaurant.setLocation(newRestaurant.getLocation());
            restaurant.setFoodType(newRestaurant.getFoodType()); 
            return repo.save(restaurant);
        }).orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }
}
