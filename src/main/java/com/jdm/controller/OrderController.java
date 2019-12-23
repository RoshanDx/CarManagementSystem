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

import com.jdm.dto.CustomerDTO;
import com.jdm.dto.OrderDTO;
import com.jdm.entity.Customer;
import com.jdm.entity.Order;
import com.jdm.entity.Vehicle;
import com.jdm.services.OrderService;

@RequestMapping(value = "/order")
@RestController
public class OrderController {

	@Autowired 
	OrderService orderService;
	
	@GetMapping
	public List<Order> findAll() {
		return orderService.findAllOrder();
	}

	@PostMapping
	public Order saveOrder(@RequestBody OrderDTO orderdto) {
		return orderService.saveOrder(orderdto);
	}

	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable("id") Integer id) {
		orderService.deleteOrder(id);
	}

	@GetMapping("/order/{id}")
	public Order getOrderById(@PathVariable("id") Integer id) {
		return orderService.findOrderById(id).get();
	}

	@PutMapping
	public void updateOrder(@RequestBody Order order) {
		orderService.updateOrder(order);
	}
	

	
}
