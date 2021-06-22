package br.com.victorcaselli.projetozup.entities.enums;

public enum Roles {
	
	COMMON(0, "ROLE_COMMON"), 
	ADMIN(1, "ROLE_ADMIN");
	
	
	private Integer code; 
	private String description;
	
	
	private Roles(Integer code, String description) {
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
	
	
	public static Roles toEnum(Integer code) { 
		if(code == null) { 
			throw new IllegalArgumentException("Code cant be null");
		}
		
		for(Roles role : Roles.values()) { 
			if(role.getCode().equals(code)) {
				return role;
			}
		}
		
		throw new IllegalArgumentException("Invalid code: "+code);
	}
	

}
