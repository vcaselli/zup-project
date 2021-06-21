package br.com.victorcaselli.projetozup.resources;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.victorcaselli.projetozup.entities.User;
import br.com.victorcaselli.projetozup.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	private final UserService service;
	
	public UserResource(UserService service) { 
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<User> save(@RequestBody User object){ 
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(object.getId())
				.toUri();
		return ResponseEntity.created(uri).body(object);
	}

}
