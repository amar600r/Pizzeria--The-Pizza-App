package com.pizzeria.request;

import java.time.LocalDateTime;

import com.pizzeria.model.Address;
import com.pizzeria.model.ContactInformation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRestaurantRequest {

	private Long id;
	private String name;
	private String description;
	private String cuisineType;
	private Address address;
	private ContactInformation contactInformation;
	private String openingHours;
	private String imageUrl;
    private LocalDateTime registrationDate;
}
