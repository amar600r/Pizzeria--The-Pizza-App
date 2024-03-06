package com.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzeria.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
