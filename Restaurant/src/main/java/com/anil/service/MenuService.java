package com.anil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anil.Repository.MenuRepository;
import com.anil.model.Menu;

@Service
public class MenuService {
	
	
	@Autowired
	private MenuRepository menurepo;
	
	public List<Menu>getallMenus(){
		return menurepo.findAll();
	}

	public Optional<Menu>getMenuById(Long id){
		return menurepo.findById(id);
		
	}
	
	public List<Menu>getMenuByRestaurantId(Long restaurantId){
		
		return menurepo.findByRestaurantId(restaurantId);
	}
	
	public Menu addMenu(Menu menu) {
		return menurepo.save(menu);
	}
	
	public Menu updateMenu(Long id,Menu newMenu) {
		
		return menurepo.findById(id)
				.map(menu->{menu.setDishName(newMenu.getDishName());
		menu.setPrice(newMenu.getPrice());
		menu.setDescription(newMenu.getDescription());
		menu.setRestaurant(newMenu.getRestaurant());
		return menurepo.save(menu);})
				.orElseThrow(()->new RuntimeException("menu not found"));
	}
	public void deleteMenu(Long id) {
		menurepo.deleteById(id);
	}
}
