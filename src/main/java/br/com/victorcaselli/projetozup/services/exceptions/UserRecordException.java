package br.com.victorcaselli.projetozup.services.exceptions;

public class UserRecordException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	
	public UserRecordException(String msg) { 
		super(msg);
	}

}
