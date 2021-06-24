package br.com.victorcaselli.projetozup.services.feignclients;

import org.springframework.stereotype.Service;

import br.com.victorcaselli.projetozup.entities.dto.VehicleDTO;

@Service
public class FeignVehicleService {
	

	
	private final FipeFeignClient fipe; 

	
	public FeignVehicleService(FipeFeignClient fipe) {
		this.fipe = fipe;
		
	}
	
	public VehicleDTO findVehicle(String brand, String years, String finalParam){ 
		return this.fipe.findVehicle(brand, years,finalParam).getBody();
	}
}
