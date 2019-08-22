package com.ordermatching.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ordermatching.demo.models.CustInfo;

@Repository
public interface CustomerRepository extends CrudRepository<CustInfo, String> {
	public CustInfo findByEmailAddress(String EmailAddress);
}
