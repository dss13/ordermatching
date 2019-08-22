package com.ordermatching.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordermatching.demo.models.SecuritiesMaster;
import com.ordermatching.demo.repositories.SecuritiesMasterRepository;

@RestController
@RequestMapping("/securities")
public class SecuritiesController {
	@Autowired
	public SecuritiesMasterRepository repo;
	@CrossOrigin(origins = "http://localhost:8000")
	@GetMapping("/getAll")
	public List<SecuritiesMaster> getAllSecurities() {
		System.out.println(2);
		return (List<SecuritiesMaster>) repo.findAll();
	}
} 
