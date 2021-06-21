package br.com.victorcaselli.projetozup.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.victorcaselli.projetozup.entities.User;
import br.com.victorcaselli.projetozup.repositories.UserRepository;
import br.com.victorcaselli.projetozup.security.UserSecurity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private final UserRepository repository; 
	
	public UserDetailsServiceImpl(UserRepository repository) {
		this.repository = repository; 
		
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		
		return new UserSecurity(user);
	}

}
