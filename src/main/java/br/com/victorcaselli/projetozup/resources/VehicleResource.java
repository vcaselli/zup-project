package br.com.victorcaselli.projetozup.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorcaselli.projetozup.entities.dto.VehicleDTO;
import br.com.victorcaselli.projetozup.services.feignclients.FeignVehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleResource {
	
	private final FeignVehicleService service;
	
	
	public VehicleResource(FeignVehicleService service) {
		this.service = service;
		
	}
	
	@GetMapping("/new")
	public ResponseEntity<VehicleDTO> findVehicle(
			@RequestParam(value="brand") String brand,
			@RequestParam(value="years") String years, 
			@RequestParam(value="final") String finalParam
			){ 
		return ResponseEntity.ok().body( this.service.findVehicle(brand,years,finalParam));
	}
	

}
