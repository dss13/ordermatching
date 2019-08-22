package com.ordermatching.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderBookRepository extends CrudRepository<OrderBook, String> {
	 @Query("SELECT OrderNumber FROM OrderBook where CustomerCode = :id") 
	 public String findOrdersById(@Param("id") String id);
}
