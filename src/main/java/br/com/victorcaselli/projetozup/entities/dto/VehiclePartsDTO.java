package br.com.victorcaselli.projetozup.entities.dto;

import java.io.Serializable;

public class VehiclePartsDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String brand; 
	private String year; 
	private String specific;
	private String vehicleType; 
	
	
	
	
	public VehiclePartsDTO(String brand, String year, String specific, String vehicleType) {
		super();
		this.brand = brand;
		this.year = year;
		this.specific = specific;
		this.vehicleType = vehicleType;
		
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSpecific() {
		return specific;
	}
	public void setSpecific(String specific) {
		this.specific = specific;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	

}
