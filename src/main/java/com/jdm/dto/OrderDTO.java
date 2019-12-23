package com.jdm.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import com.jdm.entity.Customer;
import com.jdm.entity.Employee;
import com.jdm.entity.Vehicle;

public class OrderDTO {

	private int OId;
	private Customer customer;
	private Employee employee;
	private Date date;
	private Float total;
	private Set<Vehicle> vehicles = new HashSet<Vehicle>(0);
	
	public int getOId() {
		return OId;
	}
	public void setOId(int oId) {
		OId = oId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	public Set<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	
	
}
