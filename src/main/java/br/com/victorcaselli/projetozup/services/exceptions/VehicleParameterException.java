package br.com.victorcaselli.projetozup.services.exceptions;

public class VehicleParameterException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	
	public VehicleParameterException(String msg) { 
		super(msg);
	}

}
