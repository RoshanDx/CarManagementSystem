package com.jdm.entity;
// Generated 20-Dec-2019 10:22:23 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Order generated by hbm2java
 */
@Entity
@Table(name = "order", catalog = "crud")
public class Order implements java.io.Serializable {

	private int OId;
	private Customer customer;
	private Employee employee;
	private Date date;
	private Float total;
	private Set<Vehicle> vehicles = new HashSet<Vehicle>(0);

	public Order() {
	}

	public Order(int OId, Customer customer, Employee employee) {
		this.OId = OId;
		this.customer = customer;
		this.employee = employee;
	}

	public Order(int OId, Customer customer, Employee employee, Date date, Float total, Set<Vehicle> vehicles) {
		this.OId = OId;
		this.customer = customer;
		this.employee = employee;
		this.date = date;
		this.total = total;
		this.vehicles = vehicles;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "o_id", unique = true, nullable = false)
	public int getOId() {
		return this.OId;
	}

	public void setOId(int OId) {
		this.OId = OId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_cust_id", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_emp_id", nullable = false)
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "total", precision = 12, scale = 0)
	public Float getTotal() {
		return this.total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "order_has_vehicle", catalog = "crud", joinColumns = {
			@JoinColumn(name = "order_o_id", nullable = false, updatable = true) }, inverseJoinColumns = {
					@JoinColumn(name = "vehicle_v_id", nullable = false, updatable = true) })
	public Set<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
