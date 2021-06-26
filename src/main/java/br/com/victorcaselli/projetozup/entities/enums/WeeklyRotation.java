package br.com.victorcaselli.projetozup.entities.enums;

public enum WeeklyRotation {
	
	MONDAY(1, "Segunda-feira/Monday"),
	TUESDAY(2, "Terça-feira/Tuesday"),
	WEDNESDAY(3, "Quarta-feira/Wednesday"),
	THURSDAY(4, "Quinta-feira/Thursday"), 
	FRIDAY(5, "Sexta-feira/Friday");
	
	
	private Integer code; 
	private String description;
	
	
	private WeeklyRotation(Integer code, String description) {
		this.code = code;
		this.description = description;
	}


	public Integer getCode() {
		return code;
	}


	public void setCode(Integer code) {
		this.code = code;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	} 
	
	
	public static String getWeeklyRotation(Integer lastDayofYear) { 
		return WeeklyRotation.toEnum(lastDayofYear).description;
	}
	
	
	public static WeeklyRotation toEnum(Integer code) { 
		if(code == null) { 
			throw new IllegalArgumentException("Code cant be null");
		}
		
		for(WeeklyRotation role : WeeklyRotation.values()) { 
			if(role.getCode().equals(code)) {
				return role;
			}
		}
		
		throw new IllegalArgumentException("Invalid code: "+code);
	}
	

}
