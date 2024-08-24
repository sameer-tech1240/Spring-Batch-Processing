package com.spring.batch.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.batch.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
