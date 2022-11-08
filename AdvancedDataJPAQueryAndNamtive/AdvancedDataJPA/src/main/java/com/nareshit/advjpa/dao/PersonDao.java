package com.nareshit.advjpa.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.advjpa.model.CustomType;
import com.nareshit.advjpa.model.Person;

@Repository
public interface PersonDao extends CrudRepository<Person, Integer>{

	/*
	 *
	 * Pre defined Rules for Derived Methods
	 *
	 *
	 * 1) Abstract Method should be created by developer
	 * 2) Input and Ouput are developers choice for abstract method
	 * 3) Framewill work implement based on Abstract Method Name
	 * 4) MethodName should start with "findBy" Prefix followed by  property name
	 *
	 *
	 *  public Ticket findByPassengerName(String passengerName) ==> Abstract Method
	 *  select * from tbl_ticket where passenger_name=passengerName ==> Framework will implement
	 */


	//select * from tbl_person where first_name=firstName
	public List<Person> findByFirstName(String firstName);


	//And KeyWord
	//select * from tbl_person where last_name=lastName and first_name=firstName
	public Person findByLastNameAndFirstName(String lastName,String firstName);


	//Or Keyword
	///select * from tbl_person where last_name=lastName or first_name=firstName
	public List<Person> findByLastNameOrFirstName(String lastName,String firstName);


	//OrderByKeyword
	//select * from tbl_person where last_name=lastName order by created_date desc;
	public List<Person> findByLastNameOrderByCreatedDateDesc(String lastName);

	//LessThanEqual
	//select * from tbl_person where age<=age;
	public List<Person> findByAgeLessThanEqual(Integer age);


	//Like ==> Partial Search / Wild Card Search
	//select * from tbl_person where first_name like '%firstName%';
	//% symbol should be appended manually by developer
	public List<Person> findByFirstNameLike(String firstName);


	//And and LessThanEqual
	//select * from tbl_person where last_name=lastName and age<=age
	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName,int Age);


	//Between ==> To retrieve the data between Two Dates
	//select * from tbl_person where created_date >=startdate and created_date<=endDate
	public List<Person> findByCreatedDateBetween(Date startdate,Date endDate);


	//NamedQery Section
	//Abstract method
	public List<Person> giveDataByName(String firstName);

	public List<CustomType> fetchFewColumns(String firstName);


	//Query and Native Query Section


	//Query -> We are going to write JPQL -> Writing Java Classes and Java proprties
	@Query(value="SELECT p FROM Person p where p.firstName=?1 OR p.email=?2") //Implementation
	List<Person> findPersonInfobyFirstNameorEmail(String firstName,String email); //Abstract Method

	//NativeQuery -> We are going to write SQL -> Writing database tables and database columns
	@Query(value="SELECT * FROM tbl_person p where p.first_name=?1",nativeQuery = true)//Implementation
	List<Person> findPersonINfobyFirstname(String firstName);//Abstract Method
}
