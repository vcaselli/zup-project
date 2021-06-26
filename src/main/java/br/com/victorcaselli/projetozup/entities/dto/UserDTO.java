package br.com.victorcaselli.projetozup.entities.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import br.com.victorcaselli.projetozup.entities.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Long id; 
	@NotBlank(message = "O nome não pode ser vazio ou nulo")
	private String name;
	@NotBlank(message = "Campo obrigatório")
	@Email(message="Insira um email correto")
	private String email; 
	@NotBlank(message = "Campo obrigatório")
	@CPF(message = "Digite um cpf correto")
	private String cpf; 
	@NotNull(message = "A data de nascimento não pode ser nula, presente ou futuro")
	@Past
	private Date birthDate;
	private String password;
	
	
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
	
	public String getPassword() {
		return password;
	}

	public User fromDTO() { 
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setCpf(cpf);
		user.setBirthDate(birthDate);
		return user;
	}
	
	
}
