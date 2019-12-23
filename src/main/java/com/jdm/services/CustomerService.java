package com.jdm.services;

import java.util.List;
import java.util.Optional;

import com.jdm.dto.CustomerDTO;
import com.jdm.entity.Customer;

public interface CustomerService {
	
	List <Customer> findAllCustomer();
	
	Optional<Customer> findCustomerById (Integer id);
	
	Customer saveCustomer (Customer customer);
	
	void deleteCustomer(Integer id);
	
	void updateCustomer(Customer customer);
	
	long count();
	
}

