package com.jdm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jdm.dto.CustomerDTO;
import com.jdm.dto.OrderDTO;
import com.jdm.entity.Customer;
import com.jdm.entity.Order;
import com.jdm.entity.Vehicle;

@Service
public interface OrderService {
	
	List<Order> findAllOrder();
	
	Optional<Order> findOrderById(Integer id);
	
	Order saveOrder(OrderDTO orderdto);
	
	void deleteOrder(Integer id);
	
	void updateOrder(Order order);
	
	
}
