package br.com.victorcaselli.projetozup.services;

import java.util.List;

import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.victorcaselli.projetozup.entities.Vehicle;
import br.com.victorcaselli.projetozup.repositories.VehicleRepository;
import br.com.victorcaselli.projetozup.services.security.AuthService;
import br.com.victorcaselli.projetozup.util.WeeklyRotationTools;

@Service
public class VehicleService {
	
	
	private final VehicleRepository repository;
	private final AuthService auth;

	public VehicleService(VehicleRepository repository, AuthService auth) {
		this.repository = repository;
		this.auth = auth; 
		
	}
	
	@Transactional
	public Vehicle save(Vehicle object) { 
		if(this.auth.authenticated() == null) { 
			throw new UnauthorizedClientException("User cannot be null");
		}
		object.setUser(this.auth.authenticated());
		object.setWeeklyRotation(WeeklyRotationTools.getWeeklyRotationByModelYear(object.getModelYear()));
		return this.repository.save(object);
	}
	
	@Transactional(readOnly=true)
	public List<Vehicle> findAllByUser() { 
		return  this.auth.authenticated().getVehicles();
	}
	
	
	
}
