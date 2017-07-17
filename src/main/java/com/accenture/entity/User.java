package com.accenture.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@NamedQuery(name = "User.findByNamedQuery",query = "select u from User u where u.emailId = ?1")
@Table(name="user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	@Getter	@Setter	
	private Long userId;
	
	@Column(nullable=false,unique=true)
	@Getter	@Setter	
	private String firstName;
	
	@Column(nullable=false)
	@Getter	@Setter	
	private String lastName;
	
	@Column
	@Getter	@Setter	
	private String mobile;
	
	@Column
	@Getter	@Setter	
	private String emailId;
	
	@Temporal( TemporalType.DATE)
	@DateTimeFormat(style = "yyyy-MM-dd")
	@Column
	@Getter	@Setter	
	private Date dob;
	
	@Column
	@Enumerated(EnumType.STRING)
	@Getter	@Setter	
	private Gender gender;
	
	@Column(length = 65535,columnDefinition="Text")
	@Getter	@Setter	
	private String address;
	
	
	@ManyToOne
	@JoinColumn(name="zip_Code", nullable=false)
	@Getter	@Setter	
	private ZipCode zipCode;

	@Transient 
	@Getter	@Setter	
	private int page;
	
	@Transient 
	@Getter	@Setter	
	private int recordePerPage;
	
	
	@PrePersist
	public void prePersist() {
		System.out.println("before a new entity is persisted (added to the EntityManager)");
	}
	
	@PostPersist
	public void postPersist() {
		System.out.println("after storing a new entity in the database (during commit or flush)");
	}
	@PostLoad
	public void postLoad() {
		System.out.println("after an entity has been retrieved from the database");
	}
	@PreUpdate
	public void PreUpdate() {
		System.out.println("when an entity is identified as modified by the EntityManager");
	}
	@PostUpdate
	public void PostUpdate() {
		System.out.println("after updating an entity in the database (during commit or flush)");
	}
	@PreRemove
	public void PreRemove() {
		System.out.println("when an entity is marked for removal in the EntityManager");
	}
	@PostRemove
	public void PostRemove() {
		System.out.println("after deleting an entity from the database (during commit or flush)");
	}
	
	
	
	
}
