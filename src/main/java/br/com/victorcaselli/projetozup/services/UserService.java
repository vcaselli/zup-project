package br.com.victorcaselli.projetozup.services;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.victorcaselli.projetozup.entities.User;
import br.com.victorcaselli.projetozup.repositories.UserRepository;

@Service
public class UserService {
	
	
	private final UserRepository repository;
	
	
	public UserService(UserRepository repository) {
		this.repository = repository; 
	}
	
	@Transactional
	public User save(User object) { 
		return this.repository.save(object);
	}
	
	

}
