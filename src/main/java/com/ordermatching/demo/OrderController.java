package com.ordermatching.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ordermatching.demo.models.OrderBook;
import com.ordermatching.demo.models.SecuritiesMaster;
import com.ordermatching.demo.repositories.CustomerRepository;
import com.ordermatching.demo.repositories.OrderBookRepository;
import com.ordermatching.demo.repositories.SecuritiesMasterRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	OrderBookRepository repo;
	@Autowired
	CustomerRepository custRepo;
	@Autowired
	SecuritiesMasterRepository securityRepo;
	
	@CrossOrigin(origins = "http://localhost:8000")
	@PostMapping("/add")
	public Map<String, String> newOrder(@RequestBody OrderBook orderbook) {
		HashMap<String, String> map = new HashMap<>();
		orderbook.setTradeTime(new Date());
		
		String timestamp = new SimpleDateFormat("yyMMddHHmmss").format(Calendar.getInstance().getTime());
		Random rand= new Random();
		String random = String.format("%04d",rand.nextInt(10000));
		orderbook.setOrderNumber(timestamp + random);
		
		/* Order Status updated */
		String SecurityCode = orderbook.getSecurityCode();
		SecuritiesMaster requiredSecurity = null;
		List<SecuritiesMaster> tempSecurityList = (List<SecuritiesMaster>)securityRepo.findAll();
		for(int i=0;i<tempSecurityList.size();i++) {
			if(tempSecurityList.get(i).getSecurityCode().equals(SecurityCode))
				requiredSecurity = tempSecurityList.get(i);
		}
		if(requiredSecurity == null) {
			map.put("code", "0");
			return map;
		}
		float SP = requiredSecurity.getSellingPrice();
		float BP = requiredSecurity.getBuyingPrice();		
		float price = orderbook.getPrice();
		String status = orderbook.getOrderStatus();
		if(orderbook.getDirection().equals("Buy") && status.equals("Pending"))
		{
			if(price < 0.9*BP || price > 1.1*BP)
			{
				status = "Rejected";
			}
		}
		else if(orderbook.getDirection().equals("Sell") && status.equals("Pending"))
		{
			if(price < 0.9*SP || price > 1.1*SP)
			{
				status = "Rejected";
			}
		}
		
		orderbook.setOrderStatus(status);
		
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
	@CrossOrigin(origins = "http://localhost:8000")
	@PostMapping("/update")
	public Map<String, String> updateOrder(@RequestBody OrderBook orderbook) {
		HashMap<String, String> map = new HashMap<>();
		orderbook.setTradeTime(new Date());
		try {	
			repo.save(orderbook);
			map.put("code", "1");
		} catch(Exception e) {
			map.put("code", "0");
		}
		return map;
	}
	@CrossOrigin(origins = "http://localhost:8000")
	@PostMapping("/cancel")
	public Map<String, String> cancelOrder(@RequestBody OrderBook orderbook){
		HashMap<String, String> map=new HashMap<>();
		orderbook.setOrderStatus("Cancelled");
		try {
			repo.save(orderbook);
			map.put("code", "1");
		}catch(Exception e) {
			map.put("code", "0");
		}
		return map;
	}
}
