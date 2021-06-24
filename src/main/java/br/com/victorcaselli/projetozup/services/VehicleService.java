package br.com.victorcaselli.projetozup.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.victorcaselli.projetozup.entities.Vehicle;
import br.com.victorcaselli.projetozup.repositories.VehicleRepository;

@Service
public class VehicleService {
	
	
	private final VehicleRepository repository;

	public VehicleService(VehicleRepository repository) {
		this.repository = repository; 
		
	}
	
	@Transactional
	public Vehicle save(Vehicle object) { 
		return this.repository.save(object);
	}
	
	
}
