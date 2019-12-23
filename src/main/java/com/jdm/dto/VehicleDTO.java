package com.jdm.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jdm.entity.Order;

public class VehicleDTO {

	private Integer VId;
	private String VManufacturer;
	private String VModel;
	private Integer VYear;
	private String VCategory;
	private String VTransmission;
	private Integer VMilleage;
	private String VPlate;
	private String VColor;
	private Float VPrice;

	private Set<Order> orders = new HashSet<Order>(0);

	public Integer getVId() {
		return VId;
	}

	public void setVId(Integer vId) {
		VId = vId;
	}

	public String getVManufacturer() {
		return VManufacturer;
	}

	public void setVManufacturer(String vManufacturer) {
		VManufacturer = vManufacturer;
	}

	public String getVModel() {
		return VModel;
	}

	public void setVModel(String vModel) {
		VModel = vModel;
	}

	public Integer getVYear() {
		return VYear;
	}

	public void setVYear(Integer vYear) {
		VYear = vYear;
	}

	public String getVCategory() {
		return VCategory;
	}

	public void setVCategory(String vCategory) {
		VCategory = vCategory;
	}

	public String getVTransmission() {
		return VTransmission;
	}

	public void setVTransmission(String vTransmission) {
		VTransmission = vTransmission;
	}

	public Integer getVMilleage() {
		return VMilleage;
	}

	public void setVMilleage(Integer vMilleage) {
		VMilleage = vMilleage;
	}

	public String getVPlate() {
		return VPlate;
	}

	public void setVPlate(String vPlate) {
		VPlate = vPlate;
	}

	public String getVColor() {
		return VColor;
	}

	public void setVColor(String vColor) {
		VColor = vColor;
	}

	public Float getVPrice() {
		return VPrice;
	}

	public void setVPrice(Float vPrice) {
		VPrice = vPrice;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
}
