package com.jdm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jdm.entity.Customer;
import com.jdm.entity.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

}
