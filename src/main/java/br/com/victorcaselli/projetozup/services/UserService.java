package br.com.victorcaselli.projetozup.services;



import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.victorcaselli.projetozup.entities.User;
import br.com.victorcaselli.projetozup.entities.dto.UserDTO;
import br.com.victorcaselli.projetozup.repositories.UserRepository;
import br.com.victorcaselli.projetozup.services.exceptions.UserRecordException;
import br.com.victorcaselli.projetozup.services.security.AuthService;

@Service
public class UserService {
	
	
	private final UserRepository repository;
	private final AuthService authService;
	private final BCryptPasswordEncoder encoder;
	
	public UserService(UserRepository repository, AuthService authService, BCryptPasswordEncoder encoder) {
		this.repository = repository;
		this.authService = authService;
		this.encoder = encoder; 
	}
	
	@Transactional
	public User save(User object) { 
		object.setPassword(encoder.encode(object.getPassword()));
		User user = new User(object); 
		try {
			return this.repository.save(user);
		}catch(Exception e) { 
			throw new UserRecordException(null);
		}

	}
	
	@Transactional(readOnly = true)
	public UserDTO findByEmail(String email) { 
		User user = this.repository.findByEmail(email);
		this.authService.validate(user.getId());
		return new UserDTO(user);
	}
	
	
	
	
	

}
