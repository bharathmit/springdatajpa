package com.accenture.controller;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.model.SpringBean;
import com.accenture.springcore.beanscope.Prototype;
import com.accenture.springcore.beanscope.Request;
import com.accenture.springcore.beanscope.Session;
import com.accenture.springcore.beanscope.Singleton;

@RestController
@RequestMapping("/spring")
@Log4j
public class SpringCore {
	
	
	
	@Autowired
	Singleton Singleton;
	
	@Autowired
	Prototype Prototype;
	
	@Autowired
	Request Request;
	
	@Autowired
	Session Session;
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public SpringBean update(@RequestBody SpringBean reqObject){
		log.info("update method");
		
		Session.setMessage(reqObject.getSessionMessage());
		Request.setMessage(reqObject.getRequestMessage());
		Prototype.setMessage(reqObject.getPrototypeMessage());
		Singleton.setMessage(reqObject.getSingletonMessage());
		
		return reqObject;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public SpringBean getvalue(){
		SpringBean reqObject=new SpringBean();
		
		reqObject.setSessionMessage(Session.getMessage());
		reqObject.setRequestMessage(Request.getMessage());
		reqObject.setPrototypeMessage(Prototype.getMessage());
		reqObject.setSingletonMessage(Singleton.getMessage());
		return reqObject;
	}
	

}
