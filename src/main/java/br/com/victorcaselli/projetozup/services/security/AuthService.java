package br.com.victorcaselli.projetozup.services.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.victorcaselli.projetozup.entities.User;
import br.com.victorcaselli.projetozup.entities.enums.Roles;
import br.com.victorcaselli.projetozup.repositories.UserRepository;
import br.com.victorcaselli.projetozup.security.UserSecurity;
import br.com.victorcaselli.projetozup.services.exceptions.ForbiddenException;
import br.com.victorcaselli.projetozup.services.exceptions.UnauthorizedException;

@Service
public class AuthService {
	
	
	private final UserRepository userRepository; 
	
	public AuthService(UserRepository userRepository) {
		this.userRepository = userRepository; 
		
	}
	
	public User authenticated() { 
		try {
			
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName(); 
		return this.userRepository.findByEmail(username); 
		}catch(Exception e) { 
			throw new UnauthorizedException("Unauthorized User");
		}
	}
	
	
	
	public void validate(Long userId) { 
		User user = authenticated(); 
		UserSecurity security = new UserSecurity(user);
		if(!userId.equals(user.getId()) && !security.hasRole(Roles.ADMIN)) { 
			throw new ForbiddenException("Access Denied");
		}
	}

}
