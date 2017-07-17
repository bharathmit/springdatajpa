package com.accenture;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.accenture.entity.Gender;
import com.accenture.entity.User;
import com.accenture.entity.ZipCode;
import com.accenture.repository.UserJPARepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdatajpaApplicationTests {

	@Autowired
	UserJPARepo userJPARepo;
	
	@Test
	public void contextLoads() {
		
		
		User user=new User();
		
		user.setAddress("No 4/7");
		try{
			SimpleDateFormat df=new SimpleDateFormat("DD-MM-YYYY");
			Date date=df.parse("14-02-1988");
			user.setDob(date);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		user.setEmailId("bharath@gmail.com");
		user.setFirstName("bharath");
		user.setLastName("Simbu");
		user.setGender(Gender.Male);
		user.setMobile("9789944159");
		
		ZipCode zipcode=new ZipCode();
		zipcode.setZipCode(1l);
		
		user.setZipCode(zipcode);
		
		
		
		//userJPARepo.save(user);
		
		//userJPARepo.findByEmailId("bharath@gmail.com");
		//userJPARepo.findByZipCode(zipcode);
		
		PageRequest pageable=new PageRequest(0, 10, Direction.ASC, "mobile");
		
		List<Order> orders= new ArrayList<Order>();
		orders.add(new Order(Direction.ASC,"mobile"));
		orders.add(new Order(Direction.DESC,"emailId"));
		
		
		
		Sort sort=new Sort(orders);
			  
		
		//userJPARepo.findByFirstName("bharath", pageable);
		//userJPARepo.findByLastName("Simbu", pageable);
		//userJPARepo.findByLastName("Simbu", sort);
		
		
		userJPARepo.findFirst5ByOrderByLastNameAsc();
		userJPARepo.findTop5ByOrderByLastNameDesc();
		
	}
	
	
	

}
