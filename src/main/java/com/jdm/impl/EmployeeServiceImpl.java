package com.jdm.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdm.entity.Customer;
import com.jdm.entity.Employee;
import com.jdm.repository.EmployeeRepository;
import com.jdm.services.EmployeeService;

@Service 
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	public List<Employee> findAllEmployee(){	
		return (List<Employee>) employeeRepo.findAll();
	}
	
	public Optional<Employee> findEmployeeById(Integer id) {	
		return employeeRepo.findById(id);
	}
	
	public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
	
    public void deleteEmployee(Integer id) {
    	employeeRepo.deleteById(id);
    }
    
    public void updateEmployee(Employee employee) {    	
    	employeeRepo.save(employee);
    }
	
}
