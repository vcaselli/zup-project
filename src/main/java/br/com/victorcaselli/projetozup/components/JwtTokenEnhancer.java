package br.com.victorcaselli.projetozup.components;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import br.com.victorcaselli.projetozup.entities.User;
import br.com.victorcaselli.projetozup.repositories.UserRepository;
import br.com.victorcaselli.projetozup.security.UserSecurity;



@Component
public class JwtTokenEnhancer implements TokenEnhancer {

	private final UserRepository userRepository;
	
	public JwtTokenEnhancer(UserRepository userRepository) {
		this.userRepository = userRepository; 
		
	}
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

		User account = userRepository.findByEmail(authentication.getName());
		UserSecurity user = new UserSecurity(account);
		
		Map<String, Object> map = new HashMap<>();
		map.put("userEmail", user.getUsername());
		map.put("userId", user.getId());
		map.put("role", user.getAuthorities());

		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
		token.setAdditionalInformation(map);
		
		return accessToken;
	}
}
