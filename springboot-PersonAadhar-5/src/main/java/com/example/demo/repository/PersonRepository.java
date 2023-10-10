package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Person;
import com.example.demo.model.Products;

public interface PersonRepository extends JpaRepository<Person, Long>{
	
	
}
