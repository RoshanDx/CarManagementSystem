package com.jdm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdm.entity.Customer;
import com.jdm.entity.Employee;
import com.jdm.services.CustomerService;
import com.jdm.services.EmployeeService;

@RequestMapping(value = "/employee")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// List all customer
	@GetMapping
	public List<Employee> findAll() {
		return employeeService.findAllEmployee();
	}

	// Add a customer
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	// Delete a customer
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.deleteEmployee(id);
	}

	// Get a customer by id
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable("id") Integer id) {
		return employeeService.findEmployeeById(id).get();
	}

	// Update a customer by id
	@PutMapping
	public void updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
	}
}
