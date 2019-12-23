package com.jdm.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdm.entity.Customer;
import com.jdm.entity.Vehicle;
import com.jdm.services.VehicleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@RequestMapping(value = "/vehicle")
@RestController
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping
	public List<Vehicle> findAll() {
		return vehicleService.findAllVehicle();
	}

	@PostMapping
	public Vehicle saveVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.saveVehicle(vehicle);
	}

	@DeleteMapping("/{id}")
	public void deleteVehicle(@PathVariable("id") Integer id) {
		vehicleService.deleteVehicle(id);
	}

	@GetMapping("/vehicle/{id}")
	public Vehicle getVehicle(@PathVariable("id") Integer id) {
		return vehicleService.findVehicleById(id).get();
	}

	@PutMapping
	public void updateVehicle(@RequestBody Vehicle vehicle) {
		vehicleService.updateVehicle(vehicle);
	}
	
}
