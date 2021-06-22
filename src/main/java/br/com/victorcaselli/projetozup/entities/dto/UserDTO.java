package br.com.victorcaselli.projetozup.entities.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.victorcaselli.projetozup.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Long id; 
	private String name;
	private String email; 
	private String cpf; 
	private Date birthDate;
	
	
	public UserDTO() { 
		
	}
	
	public UserDTO(User entity) { 
		this.id = entity.getId(); 
		this.name = entity.getName(); 
		this.email = entity.getEmail(); 
		this.cpf = entity.getCpf(); 
		this.birthDate = entity.getBirthDate();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public Date getBirthDate() {
		return birthDate;
	}
	
	
}
