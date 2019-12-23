package com.jdm.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdm.dto.OrderDTO;
import com.jdm.entity.Order;
import com.jdm.repository.OrderRepository;
import com.jdm.services.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepo;
	
	public List<Order> findAllOrder(){	
		return (List<Order>) orderRepo.findAll();
	}
	
	public Optional<Order> findOrderById(Integer id) {	
		return orderRepo.findById(id);
	}
	
	public Order saveOrder(OrderDTO orderdto) {
			
		Order order = new Order();
		
		order.setDate(orderdto.getDate());
		order.setTotal(orderdto.getTotal());
		order.setVehicles(orderdto.getVehicles());
		order.setCustomer(orderdto.getCustomer());
		order.setEmployee(orderdto.getEmployee());

        return orderRepo.save(order);
    }
    public void deleteOrder(Integer id) {
    	orderRepo.deleteById(id);
    }
    
    public void updateOrder(Order order) {    	
    	orderRepo.save(order);
    }

    
}
