package com.ordermatching.demo;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {
    public Customer findByEmail(String Email);
}
