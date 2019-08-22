package com.ordermatching.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ordermatching.demo.models.OrderBook;

@Repository
public interface OrderBookRepository extends CrudRepository<OrderBook, String> {
	 @Query("SELECT ob FROM OrderBook ob where ob.CustomerCode = :id")
	 public List<OrderBook> findOrdersById(String id);
}
