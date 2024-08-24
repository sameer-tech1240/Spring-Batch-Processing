package com.spring.batch.demo.config;

import org.springframework.batch.item.ItemProcessor;

import com.spring.batch.demo.entity.Customer;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

	@Override
	public Customer process(Customer customer) throws Exception {
		if (customer.getGender().equalsIgnoreCase("male")) {

			if (customer.getFirstName().toLowerCase().contains("s")) {

				return customer;

			} else {

				return null;

			}
		} else {

			return null;

		}
	}

}
