package br.com.victorcaselli.projetozup.resources;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.victorcaselli.projetozup.entities.Vehicle;
import br.com.victorcaselli.projetozup.services.VehicleService;
import br.com.victorcaselli.projetozup.services.feignclients.FeignVehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleResource {
	
	private final FeignVehicleService fipeService;
	private final VehicleService service;
	
	public VehicleResource(FeignVehicleService service, VehicleService service2) {
		this.fipeService = service;
		this.service = service2;
		
	}
	
	@GetMapping
	public ResponseEntity<List<Vehicle>> findAll(){ 
		return ResponseEntity.ok().body(this.service.findAllByUser());
	}
	
	@PostMapping("/new")
	public ResponseEntity<Vehicle> findVehicle(
			@RequestParam(value="brand") String brand,
			@RequestParam(value="years") String years, 
			@RequestParam(value="final") String finalParam
			){ 
		Vehicle vehicle = this.fipeService.findVehicle(brand,years,finalParam);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(vehicle.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(vehicle);
	}
	

}
