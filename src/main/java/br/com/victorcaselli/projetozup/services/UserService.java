package br.com.victorcaselli.projetozup.services;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.victorcaselli.projetozup.entities.User;
import br.com.victorcaselli.projetozup.entities.dto.UserDTO;
import br.com.victorcaselli.projetozup.entities.enums.Roles;
import br.com.victorcaselli.projetozup.repositories.UserRepository;

@Service
public class UserService {
	
	
	private final UserRepository repository;
	
	
	public UserService(UserRepository repository) {
		this.repository = repository; 
	}
	
	@Transactional
	public User save(User object) { 
		User user = new User(object); 
		user.getRoles().add(Roles.COMMON);
		return this.repository.save(user);

	}
	
	@Transactional(readOnly = true)
	public UserDTO findByEmail(String email) { 
		return new UserDTO(this.repository.findByEmail(email));
	}
	
	
	
	
	

}
