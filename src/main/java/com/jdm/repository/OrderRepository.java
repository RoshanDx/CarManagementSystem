package com.jdm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jdm.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>{

}
