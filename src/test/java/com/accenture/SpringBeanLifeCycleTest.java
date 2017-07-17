package com.accenture;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.springcore.DI.ExcelHelper;
import com.accenture.springcore.DI.PDFHelper;
import com.accenture.springcore.beanscope.BeanLifeCycle;
import com.accenture.springcore.beanscope.Singleton;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBeanLifeCycleTest {

	
	@Autowired
	BeanLifeCycle beanLifeCycle;
	
	@Autowired
	Singleton singleton;
	
	
	@Autowired
	PDFHelper PDFHelper;
	
	@Autowired
	ExcelHelper ExcelHelper;
	
	
	@Test
	public void test(){
		System.out.println("Junit Test Call the Message:"+beanLifeCycle.getMessage());
		
		singleton.displayInfo();
		
		PDFHelper.DisplayOutput();
		
		ExcelHelper.DisplayOutput();
		
		
		
	}
}
