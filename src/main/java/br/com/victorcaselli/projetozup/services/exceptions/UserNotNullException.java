package br.com.victorcaselli.projetozup.services.exceptions;

public class UserNotNullException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	
	public UserNotNullException(String msg) { 
		super(msg);
	}

}
