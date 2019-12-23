package com.jdm.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdm.entity.Vehicle;
import com.jdm.repository.VehicleRepository;
import com.jdm.services.VehicleService;


@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepo;
	
	public List<Vehicle> findAllVehicle(){	
		return (List<Vehicle>) vehicleRepo.findAll();
	}
	
	public Optional<Vehicle> findVehicleById(Integer id) {	
		return vehicleRepo.findById(id);
	}
	
	public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }
	
    public void deleteVehicle(Integer id) {
       vehicleRepo.deleteById(id);
    }
    
    public void updateVehicle(Vehicle vehicle) {	
    	vehicleRepo.save(vehicle);
    }

}
