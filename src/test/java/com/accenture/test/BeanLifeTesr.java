package com.accenture.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.accenture.springcore.beanscope.BeanLifeCycle;

public class BeanLifeTesr {

	 public static void main(String[] args) {
	       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
	       ctx.register(AppConfig.class);
	       ctx.refresh();
	       BeanLifeCycle bean = ctx.getBean(BeanLifeCycle.class);
	       System.out.println("Junit Method Message Called:"+ bean.getMessage());
	       ctx.close();
	   }
	 
}

