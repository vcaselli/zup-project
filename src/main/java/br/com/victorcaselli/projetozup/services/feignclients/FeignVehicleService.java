package br.com.victorcaselli.projetozup.services.feignclients;

import org.springframework.stereotype.Service;

import br.com.victorcaselli.projetozup.entities.Vehicle;
import br.com.victorcaselli.projetozup.entities.dto.VehicleDTO;
import br.com.victorcaselli.projetozup.services.VehicleService;
import br.com.victorcaselli.projetozup.services.exceptions.UnauthorizedException;
import br.com.victorcaselli.projetozup.services.exceptions.VehicleParameterException;

@Service
public class FeignVehicleService {
	

	
	private final FipeFeignClient fipe; 
	private final VehicleService service;

	
	public FeignVehicleService(FipeFeignClient fipe, VehicleService service) {
		this.fipe = fipe;
		this.service = service;
		
	}
	
	public Vehicle findVehicle(String brand, String years, String finalParam){ 
		Vehicle vehicle;
		try {
			vehicle = this.fipe.findVehicle(brand, years,finalParam).getBody().fromDTO();
		}catch(Exception e) { 
			throw new VehicleParameterException("Some of the required parameters are incorrect or not found.");
		}
		return this.service.save(vehicle);
	}
	
	
	
}
