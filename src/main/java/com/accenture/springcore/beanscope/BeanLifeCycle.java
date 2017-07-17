package com.accenture.springcore.beanscope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;




public class BeanLifeCycle implements  InitializingBean, DisposableBean, BeanFactoryAware, BeanNameAware, BeanClassLoaderAware, BeanPostProcessor {
	
	
	private String message;
	
	
	public BeanLifeCycle (){
		System.out.println("1.Step BeanLifeCycle no-args constructor called");
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	@Override
	public void setBeanName(String name) {
		System.out.println("2.Step BeanLifeCycle setBeanName called");
		System.out.println("setBeanName:: Bean Name defined in context="+ name);
		
	}
	
	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("3.Step BeanLifeCycle setBeanClassLoader called");
		System.out.println("setBeanClassLoader:: ClassLoader Name=" + classLoader.getClass().getName());
		
	}


	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("4.Step BeanLifeCycle setBeanFactory");
		
	}
	
	
	@PostConstruct
	public void init(){
		System.out.println("5.Step BeanLifeCycle Java annotation  init method called @PostConstruct");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("6.Step BeanLifeCycle initializing afterPropertiesSet");
		
	}

	
	
	public void myPostConstruct() {
   	 	System.out.println("7.Step ---init-method---  setting the message to Hello Spring Bean :" );
   	 	setMessage("Hello Spring Bean");
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("8.Step BeanLifeCycle BeanPostProcessor.postProcessAfterInitialization="+beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("8.Step BeanLifeCycle BeanPostProcessor.postProcessBeforeInitialization="+beanName);
		return bean;
	}
	
	@PreDestroy
	public void destory(){
		System.out.println("9.Step BeanLifeCycle Java annotation destroy method called @PreDestroy");
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("10.Step BeanLifeCycle Closing resources");
		
	}
	
	public void myPreDestroy() {
		System.out.println("11.Step ---destroy-method---");
	}

	
	
	
	

}
