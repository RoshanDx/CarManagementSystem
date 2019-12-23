package com.jdm.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jdm.dto.CustomerDTO;
import com.jdm.entity.Customer;
import com.jdm.repository.CustomerRepository;
import com.jdm.services.CustomerService;

@Service 	
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public long count() {
		return customerRepo.count();
	}
	
	public List<Customer> findAllCustomer(){	
		return (List<Customer>) customerRepo.findAll();
	}
	
	public Optional<Customer> findCustomerById(Integer id) {	
		return customerRepo.findById(id);
	}
	
	public Customer saveCustomer(Customer customer) {
        
//		Customer customer = new Customer();
//		customer.setCustId(customerdto.getCustId());
//		customer.setCustName(customerdto.getCustName());
//		customer.setCustAddress(customerdto.getCustAddress());
//		customer.setCustPhone(customerdto.getCustPhone());
//		customer.setCustGender(customerdto.getCustGender());
		
		return customerRepo.save(customer);
    }
	
    public void deleteCustomer(Integer id) {
       customerRepo.deleteById(id);
    }
    
    public void updateCustomer(Customer customer) {
    	
    	customerRepo.save(customer);
    }

}
