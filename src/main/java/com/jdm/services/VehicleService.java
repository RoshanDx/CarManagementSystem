package com.jdm.services;

import java.util.List;
import java.util.Optional;

import com.jdm.entity.Vehicle;

public interface VehicleService {
	
	List<Vehicle> findAllVehicle();
	
	Optional<Vehicle> findVehicleById(Integer id);
	
	Vehicle saveVehicle(Vehicle vehicle);
	
	void deleteVehicle(Integer id);
	
	void updateVehicle(Vehicle vehicle);

}
