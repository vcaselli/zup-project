package br.com.victorcaselli.projetozup.services.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.victorcaselli.projetozup.entities.dto.VehicleDTO;

@Component
@FeignClient(name = "FipeClient", url = "https://parallelum.com.br/fipe/api/v1/carros")
public interface FipeFeignClient {
	
	
	@GetMapping("/marcas/{brand}/modelos/{years}/anos/{finalParam}")
	public ResponseEntity<VehicleDTO> findVehicle(@PathVariable String brand,@PathVariable String years , @PathVariable String finalParam);

}
