package com.accenture.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="zip_code")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ZipCode implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter	@Setter	
	private Long zipCode;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String locationName;
	
	@Column(nullable=false, unique=true )
	@Getter	@Setter	
	private String pinCode;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String district;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String state;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String country;
	


	
	
	

}
