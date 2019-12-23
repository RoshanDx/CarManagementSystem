package com.jdm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdm.entity.Customer;
import com.jdm.entity.Employee;
import com.jdm.repository.CustomerRepository;
import com.jdm.repository.EmployeeRepository;

@Service
public interface EmployeeService {
	
	List<Employee> findAllEmployee();
	Optional<Employee> findEmployeeById(Integer id);
	Employee saveEmployee(Employee employee);
	void deleteEmployee(Integer id);
	void updateEmployee(Employee employee);
	
}
