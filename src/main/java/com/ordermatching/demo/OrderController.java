package com.ordermatching.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@Autowired
	OrderBookRepository repo;
	@CrossOrigin(origins = "http://localhost:8000")
	@PostMapping("/addOrder")
	public String newOrder(@RequestBody OrderBook orderbook) {
		try {
			repo.save(orderbook);
		} catch(Exception e) {
			return e.toString();
		}
		return "";		
	}
	@CrossOrigin(origins = "http://localhost:8000")
	@GetMapping("/getOrders")
	public String getOrdersOfUser(@RequestParam("id") String id) {
		return repo.findOrdersById(id);
	}
}
