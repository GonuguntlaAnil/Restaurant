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

import com.anil.model.Menu;
import com.anil.service.MenuService;


@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuservice;
	
	@GetMapping
	public List<Menu>getAllmenus(){
		return menuservice.getallMenus();
	}
	
	@GetMapping("/{menuid}")
	public Optional<Menu> getMenuById(@PathVariable Long menuid){
		return menuservice.getMenuById(menuid);
	}
	
	@GetMapping("/restaurant/{id}")
	public List<Menu>getMenusByRestaurantid(@PathVariable Long id){
		return menuservice.getMenuByRestaurantId(id);
	}
	
	@PostMapping("/addmenu")
	public Menu addMenu(@RequestBody Menu newMenu) {
		return menuservice.addMenu(newMenu);
	}

	@PutMapping("/updatemenu/{id}")
	public Menu updateMenu( @PathVariable Long id,  @RequestBody Menu newMenu) {
		return menuservice.updateMenu(id, newMenu);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteMenu(@PathVariable Long id) {
		menuservice.deleteMenu(id);
	}
}
