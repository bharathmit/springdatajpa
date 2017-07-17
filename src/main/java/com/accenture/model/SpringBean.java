package com.accenture.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SpringBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Getter	@Setter	
	private String singletonMessage;
	
	@Getter	@Setter	
	private String prototypeMessage;
	
	@Getter	@Setter	
	private String requestMessage;
	
	@Getter	@Setter	
	private String sessionMessage;
	
	@Getter	@Setter	
	private String globalMessage;
	
	
	

}
