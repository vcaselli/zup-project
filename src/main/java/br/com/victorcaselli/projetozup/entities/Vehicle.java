package br.com.victorcaselli.projetozup.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.victorcaselli.projetozup.entities.enums.WeeklyRotation;
import br.com.victorcaselli.projetozup.util.WeeklyRotationHandler;

@Entity
@Table(name="tb_vehicle")
public class Vehicle implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	private String brand;
	private String model;
	private Integer modelYear; 
	private String fuel; 
	private String fipeCode; 
	private String reference; 
	private Integer vehicleType;
	private Character fuelChar;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	private Integer weeklyRotation;
	private Boolean rotationState; 
	
	public Vehicle() { 
		
	}
	
	public Vehicle(Long id, String brand, String model, Integer modelYear, String fuel, String fipeCode,
			String reference, Integer vehicleType, Character fuelChar) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.modelYear = modelYear;
		this.fuel = fuel;
		this.fipeCode = fipeCode;
		this.reference = reference;
		this.vehicleType = vehicleType;
		this.fuelChar = fuelChar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getModelYear() {
		return modelYear;
	}

	public void setModelYear(Integer modelYear) {
		this.modelYear = modelYear;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getFipeCode() {
		return fipeCode;
	}

	public void setFipeCode(String fipeCode) {
		this.fipeCode = fipeCode;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Integer getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(Integer vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Character getFuelChar() {
		return fuelChar;
	}

	public void setFuelChar(Character fuelChar) {
		this.fuelChar = fuelChar;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getWeeklyRotation() {
		return WeeklyRotation.toEnum(this.weeklyRotation).getDescription();
	}

	public void setWeeklyRotation(Integer weeklyRotation) {
		this.weeklyRotation = weeklyRotation;
	}

	public Boolean getRotationState() {
		this.rotationState = WeeklyRotationHandler.onDayOfWeek(WeeklyRotation.toEnum(this.weeklyRotation));
		return this.rotationState;
	}
	
	
	
	

}
