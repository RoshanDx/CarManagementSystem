package com.jdm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jdm.dto.CustomerDTO;
import com.jdm.entity.Customer;
import com.jdm.impl.CustomerServiceImpl;
import com.jdm.repository.CustomerRepository;
import com.jdm.services.CustomerService;

@RequestMapping(value = "/customer")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	public long count() {
		return customerService.count();
	}

	// List all customer
	@GetMapping
	public List<Customer> findAll() {
		return customerService.findAllCustomer();
	}

	// Add a customer
	@PostMapping
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	// Delete a customer
	@DeleteMapping("/{id}")
	public void deleteCustomer(@PathVariable("id") Integer id) {
		customerService.deleteCustomer(id);
	}

	// Get a customer by id
	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable("id") Integer id) {
		return customerService.findCustomerById(id).get();
	}

	// Update a customer by id
	@PutMapping
	public void updateCustomer(@RequestBody Customer customer) {
		customerService.updateCustomer(customer);
	}
	
	// Get a customer by id
//	@GetMapping("/customer/{id}")
//	public Customer updateCustomerById(@PathVariable("id") Integer id ,@RequestBody Customer customer) {
//		return customerService.findCustomerById(id).get();
//	}

}
