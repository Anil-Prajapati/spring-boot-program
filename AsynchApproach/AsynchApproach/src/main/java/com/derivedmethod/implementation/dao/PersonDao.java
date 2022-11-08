package com.derivedmethod.implementation.dao;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.derivedmethod.implementation.model.CustomType;
import com.derivedmethod.implementation.model.Person;

@Repository
public interface PersonDao extends CrudRepository<Person, Integer> {
	
	// If we want to get the data from person table based on firstName
		// findByFirstName -> "findBy" -> Prefix and Propertyname -> suffix
		// Camelcase Notation
		// Internaly , it writes select * from person_table where first_name=?firstName
		public List<Person> findByFirstName(String firstName);

		// And KeyWord
		// If we want to retrieve the data using more than one column then we can use
		// And Keyword.
		// JPQL -> select * from person where firstName=?1 and lastName=?2
		public Person findByFirstNameAndLastName(String firstName, String lastName);

		// OR KeyWord
		// If we want to retrieve the data using more than one column then we can use
		// OR Keyword.
		// JPQL -> Select * from person where firstName=?1 or lastName=?2
		public List<Person> findByFirstNameOrLastName(String firstName, String lastName);
		
		
		// OrderBy
		// This will does sorting based on columnName
		// select * from person where lastName=?1 order by lastName desc;
		// selet * from person where lastName=?1 order by creationDate desc;
		//findBy
		//LastName
		//OrderBy
		//CreatedDate
		//Desc
		public List<Person> findByLastNameOrderByCreatedDateDesc(String lastName);
		

		// LessThanEqual
		// It will filter the data only one column
		// It applies <= operator in the JPQL and SQL Query
		//JPQL -> Select * from person where age<=?1
		public List<Person> findByAgeLessThanEqual(Integer age);

	

		// LikeSerach
		// We need to manually append % symbol before calling this api
		// select * from person where firstName like '%?%'
		public List<Person> findByFirstNameLike(String firstName);
		
		

		
		//JPQL -> Select * from person where last_name=?1 and age<=?2
		//findBy
		//LastName -> ColumnName1
		//And -> keyword1
		//Age -> ColumnName2
		//LessThanEqual -> Keyword2
		public List<Person> findByLastNameAndAgeLessThanEqual(String lastName,int Age);
		
		
		//JPQL -> Select * from person where createdate<=?1 and createddate>=?2
		public List<Person> findByCreatedDateBetween(Date startdate,Date endDate);
		
		
		
		
		//This is the abstract method and implementation in Person.searchpersonbyLastname whih is
		//Named Query
		public List<Person> searchpersonbyLastname(String lastName);
		
		
		//This is the abstract method and implementation in Person.searchpersonbyLastname whih is
	    //Named Query
		public Person searchbybothnames(String firstName,String lastName);
		
		
		

		//This is the to get only few columns rather than getting all column Names
		public List<CustomType> givefewcolumns(String lastName);
		
		
		
		@Query(value="SELECT p FROM Person p where p.firstName=?1 OR p.email=?2")
		List<Person> findPersonInfobyFirstNameorEmail(String firstName,String email);
		
		
		@Query(value="SELECT * FROM person_table p where p.first_name=?1",nativeQuery = true)
		List<Person> findPersonINfobyFirstname(String firstName);

		
		List<Person> findByLastName(String lastName, Pageable pageable);
		
		
		List<Person> findByEmail(String email); //Synch Method
		
		@Async("asyncthreadpool")
		CompletableFuture<Person> findByemail(String email);  //Asynch Method
		 
		
		

}
