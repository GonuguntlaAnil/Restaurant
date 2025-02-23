package com.anil.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="menus")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	
	@Column(nullable = false)
	private String dishName;
	
	
	@Column(nullable = false)
	private Double price;
	
	

	private String description;
	
	
	@ManyToOne
	@JoinColumn(name="restaurant_id",nullable=false)
	private Restaurant restaurant;
	

}
