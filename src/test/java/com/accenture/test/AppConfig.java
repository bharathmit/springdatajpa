package com.accenture.test;

import org.springframework.context.annotation.Bean;

import com.accenture.springcore.beanscope.BeanLifeCycle;


public class AppConfig {
	
	@Bean(name = "beanLifeCycle", initMethod="myPostConstruct", destroyMethod="myPreDestroy")
	public BeanLifeCycle getBean(){
		return new BeanLifeCycle();
	}

}
