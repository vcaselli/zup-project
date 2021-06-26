package br.com.victorcaselli.projetozup.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.victorcaselli.projetozup.entities.User;
import br.com.victorcaselli.projetozup.entities.dto.UserDTO;
import br.com.victorcaselli.projetozup.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	private final UserService service;
	
	public UserResource(UserService service) { 
		this.service = service;
	}
	
	@PostMapping("/new")
	public ResponseEntity<UserDTO> save(@Valid @RequestBody UserDTO object){ 
		User user = service.save(object.fromDTO());
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(object.getId())
				.toUri();
		return ResponseEntity.created(uri).body(new UserDTO(user));
	}
	
//	@GetMapping
//	public ResponseEntity<UserDTO> findByEmail(@RequestParam(value="email") String email){ 
//		return ResponseEntity.ok().body(this.service.findByEmail(email));
//	}
	
	
	

}
