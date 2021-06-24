package br.com.victorcaselli.projetozup.resources.exceptions.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OAuthCustomError implements  Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private String error; 
	
	@JsonProperty("error_description")
	private String errorDescription; 
	
	
	public OAuthCustomError() { 
		
	}


	public OAuthCustomError(String error, String errorDescription) {
		super();
		this.error = error;
		this.errorDescription = errorDescription;
	}
	
	

}
