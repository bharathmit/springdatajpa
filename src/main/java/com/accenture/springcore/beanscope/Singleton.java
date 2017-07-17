package com.accenture.springcore.beanscope;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;


public class Singleton {
	
	@Getter	@Setter	
	private String message;
	
	@Getter	@Setter
	private List addressList;
	
	@Getter	@Setter
	private Set addressSet;
	
	@Getter	@Setter
	private Map addressMap;
	
	@Getter	@Setter
	private Properties pros;
	
	public Singleton(String message){
		this.message=message;
	}
	
	
	
	public void displayInfo(){  
	    System.out.println("Message : "+message);  
	    System.out.println("addressList :");  
	    Iterator<List> itr=addressList.iterator();  
	    while(itr.hasNext()){  
	        System.out.println(itr.next());  
	    }  
	}  
	
	
}
