package com.accenture.repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;
import org.springframework.util.concurrent.ListenableFuture;

import com.accenture.entity.User;
import com.accenture.entity.ZipCode;



@Repository
public interface UserJPARepo extends JpaRepository< User, Long>{
	
	//QueryMethod
	List<User> findByEmailId(String email);
	
	//Property expressions
	List<User> findByZipCode(ZipCode zipCode);
	
	
	//Special parameter handling
	List<User> findByFirstName(String firstName, Pageable pageable);
	Slice<User> findByLastName(String lastname, Pageable pageable);
	List<User> findByLastName(String lastname, Sort sort);
	
	//Limiting query results
	List<User> findFirst5ByOrderByLastNameAsc();
	List<User> findTop5ByOrderByLastNameDesc();
	
	//Streaming query results
	Stream<User> readAllByFirstNameNotNull();
	
	//Async query results
	@Async
	Future<User> findByFirstName(String firstname);               
	
	@Async
	CompletableFuture<User> findOneByFirstName(String firstname); 
	
	@Async
	ListenableFuture<User> findOneByLastName(String lastname);  
	
	
	
	//namedQuery
	List<User> findByNamedQuery(String email);
	
	//Query
	@Query(value = "select u from User u where u.emailId = ?1")
	List<User> findByQuery(String email);
	
	//nativeQuery
	@Query(value = "select * from User u where u.email_Id = ?1", nativeQuery = true)
	List<User> nativeQueryByEmail(String email);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update User u set u.emailId = :emailId")
	int updateEMail(@Param("emailId") String emailId);

	 
}
