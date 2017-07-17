package com.accenture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import com.accenture.springcore.beanscope.BeanLifeCycle;

@SpringBootApplication
@ImportResource("classpath:springbeanlife.xml" )
public class SpringdatajpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}
	
	@Bean(name = "beanLifeCycle", initMethod="myPostConstruct", destroyMethod="myPreDestroy")
	public BeanLifeCycle getBean(){
		return new BeanLifeCycle();
	}
	
	
}
