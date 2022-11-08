package com.nareshit.derivedmethods.dao;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.nareshit.derivedmethods.model.CustomType;
import com.nareshit.derivedmethods.model.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer>{


		//We need to write derived Methods here

		//select * from tbl_person where last_name=lastName
		public Iterable<Person> findByLastName(String lastName);


		//select * from tbl_person where last_name=lastName and first_name=firstName
		public Person findByLastNameAndFirstName(String lastName,String firstName);


		//public Person findByLastNameAndFirstNameAndEmailAndAgeAndCreatedDate(String lastName,String firstName,String email);


		//select * from tbl_person where last_name=lastName or first_name=firstName
		public Iterable<Person> findByLastNameOrFirstName(String lastName,String firstName);



		//findByLastNameOrderByCreadDateDesc ==> lastName, CreatedDate
		//select * from tbl_ticket where last_name=lastName order by created_date desc
		public Iterable<Person> findByLastNameOrderByCreatedDateDesc(String lastName);

		//LessThanEqual
		//select * from tbl_ticket where age<=50
		public Iterable<Person> findByAgeLessThanEqual(Integer age);




		//select * from tbl_person where first_name like '%?%';  //Wild Card Search
		//% symbol should be appended by developer
		public List<Person> findByFirstNameLike(String firstName);



		//select * from tbl_person where last_name=? and age<=?
		public List<Person> findByLastNameAndAgeLessThanEqual(String lastName,int Age);



		//select * from tbl_person where createdate>=?1 ad created_date <=?2
		public List<Person> findByCreatedDateBetween(Date startdate,Date endDate);



		//Abstract method at Interface and Implementation at POJO Class --> Named Query
		public List<Person> fetchDataWithName(String firstName);


		public List<CustomType> fetchFewColumns(String firstName);




		//Query -> We are going to write JPQL -> Writing Java Classes and Java proprties
		@Query(value="SELECT p FROM Person p where p.firstName=?1 OR p.email=?2")
		List<Person> findPersonInfobyFirstNameorEmail(String firstName,String email);



		//NativeQuery -> We are going to write SQL -> Writing database tables and database columns
		@Query(value="SELECT * FROM tbl_person p where p.first_name=?1",nativeQuery = true)
		List<Person> findPersonINfobyFirstname(String firstName);


		//Paignation

		public List<Person> findByLastName(String lastName,Pageable pageRequest);




		public List<Person> findByEmail(String email); //Synch Method


		//@Async
		@Async("asyncthreadpool")
		CompletableFuture<Person> findByemail(String email);  //Asynch Method




}
