package br.com.victorcaselli.projetozup.resources;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.victorcaselli.projetozup.entities.Vehicle;
import br.com.victorcaselli.projetozup.services.feignclients.FeignVehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleResource {
	
	private final FeignVehicleService service;
	
	
	public VehicleResource(FeignVehicleService service) {
		this.service = service;
		
	}
	
	@PostMapping("/new")
	public ResponseEntity<Vehicle> findVehicle(
			@RequestParam(value="brand") String brand,
			@RequestParam(value="years") String years, 
			@RequestParam(value="final") String finalParam
			){ 
		Vehicle vehicle = this.service.findVehicle(brand,years,finalParam);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(vehicle.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(vehicle);
	}
	

}
