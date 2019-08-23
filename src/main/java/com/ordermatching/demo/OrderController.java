package com.ordermatching.demo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ordermatching.demo.models.OrderBook;
import com.ordermatching.demo.repositories.OrderBookRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	OrderBookRepository repo;
	@CrossOrigin(origins = "http://localhost:8000")
	@PostMapping("/add")
	public Map<String, String> newOrder(@RequestBody OrderBook orderbook) {
		HashMap<String, String> map = new HashMap<>();
		orderbook.setTradeTime(new Date());
		try {
			repo.save(orderbook);
			map.put("code", "1");
		} catch(Exception e) {
			map.put("code", e.toString());
		}
		return map;		
	}
	@CrossOrigin(origins = "http://localhost:8000")
	@GetMapping("/getOrders")
	public List<OrderBook> getOrdersOfUser(@RequestParam("id") String id) {
		return repo.findOrdersById(id);
	}
}
