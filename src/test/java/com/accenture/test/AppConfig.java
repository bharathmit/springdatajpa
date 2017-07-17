package com.accenture.test;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;

import com.accenture.springcore.autowire.Ability;
import com.accenture.springcore.autowire.Person;
import com.accenture.springcore.beanscope.BeanLifeCycle;


public class AppConfig {
	
	@Bean(name = "beanLifeCycle", initMethod="myPostConstruct", destroyMethod="myPreDestroy")
	public BeanLifeCycle getBean(){
		return new BeanLifeCycle();
	}
	
	@Bean(name = "person")
	public Person getPerson(){
		return new Person();
	}
	
	@Bean(name = "ability")
	public Ability getAbility(){
		Ability ability=new Ability();
		ability.setSkill("Spring Framework");
		return ability;
	}
	
	@Bean(name = "ability1")
	public Ability getAbility1(){
		Ability ability=new Ability();
		ability.setSkill("Spring Framework1");
		return ability;
	}

}
