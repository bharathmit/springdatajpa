package com.accenture.springcore.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Getter;
import lombok.Setter;

public class Person {

	@Autowired
	@Qualifier("ability")
	@Getter	@Setter	
	private Ability ability;
	
	public void DisplayOutput() {
		System.out.println("Ability :"+ability.getSkill());
	}
	
}
