package com.ordermatching.demo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ordermatching.demo.models.CustInfo;
import com.ordermatching.demo.repositories.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerRepository repo;
	@CrossOrigin(origins = "http://localhost:8000")
	@PostMapping("/auth")
	public Map<String, String> checkUser(@RequestBody CustInfo custInfo) {
		HashMap<String, String> map = new HashMap<>();
		
		CustInfo ci = repo.findByEmailAddress(custInfo.getEmailAddress());
		String password1 = ci.getPassword();
		String password2 = custInfo.getPassword();
		System.out.print(password1 + " " + password2);
		if (password1.equals(password2)) {
			map.put("code", "1");
			map.put("token", ci.getCustomerCode());
		} else {
			map.put("code", "0");
//			String text="Invalid Login !";
//			try (PrintWriter out = new PrintWriter("Exception.txt")) {
//			    out.println(text);
//			    out.close();
//			}
//			catch(IOException eon) {
//				//System.out.println("\n---------------------dajsajkhska------------\n");
//			}
		}
		return map;
	}
}
