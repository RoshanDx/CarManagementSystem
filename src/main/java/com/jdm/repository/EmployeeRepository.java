package com.jdm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jdm.entity.Employee;

@Repository 
public interface EmployeeRepository extends CrudRepository<Employee,Integer>{

}
