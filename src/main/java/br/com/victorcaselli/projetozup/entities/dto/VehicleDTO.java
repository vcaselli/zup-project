package br.com.victorcaselli.projetozup.entities.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class VehicleDTO {
	
	@JsonAlias(value = "Marca")
	private String brand;
	@JsonAlias(value = "Modelo")
	private String model;
	@JsonAlias(value = "AnoModelo")
	private Integer modelYear; 
	@JsonAlias(value = "Combustivel")
	private String fuel; 
	@JsonAlias(value = "CodigoFipe")
	private String fipeCode; 
	@JsonAlias(value = "MesReferencia")
	private String reference; 
	@JsonAlias(value = "TipoVeiculo")
	private Integer vehicleType;
	@JsonAlias(value = "SiglaCombustivel")
	private Character fuelChar;
	
	
	public VehicleDTO(){ 
		
	}

	public VehicleDTO(String brand, String model, Integer modelYear, String fuel, String fipeCode, String reference,
			Integer vehicleType, Character fuelChar) {
		super();
		this.brand = brand;
		this.model = model;
		this.modelYear = modelYear;
		this.fuel = fuel;
		this.fipeCode = fipeCode;
		this.reference = reference;
		this.vehicleType = vehicleType;
		this.fuelChar = fuelChar;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public Integer getModelYear() {
		return modelYear;
	}

	public String getFuel() {
		return fuel;
	}

	public String getFipeCode() {
		return fipeCode;
	}

	public String getReference() {
		return reference;
	}

	public Integer getVehicleType() {
		return vehicleType;
	}

	public Character getFuelChar() {
		return fuelChar;
	}
	
	
	
	
	

}
