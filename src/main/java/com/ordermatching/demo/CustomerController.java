package com.ordermatching.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CustomerController {
	@Autowired
	CustomerRepository repo;
	
	@GetMapping("/all")
	public List<Customer> getAll() {
		return (List<Customer>) repo.findAll();
	}
}
