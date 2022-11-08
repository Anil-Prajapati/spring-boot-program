package com.nareshit.derivedmethods.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nareshit.derivedmethods.dao.BookDao;
import com.nareshit.derivedmethods.dao.EmployeeDao;
import com.nareshit.derivedmethods.dao.PersonDao;
import com.nareshit.derivedmethods.model.Book;
import com.nareshit.derivedmethods.model.CustomType;
import com.nareshit.derivedmethods.model.Employee;
import com.nareshit.derivedmethods.model.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;


	@Autowired
	private BookDao bookDao;


	@Autowired
	private EmployeeDao empDao;


	//SaveAll
	//This method will save collection of Entities through on DAO Call

	public Iterable<Person> saveAllPersons(Iterable<Person> personList){

		return personDao.saveAll(personList);
	}

	public Person savePerson(Person person) {
		return personDao.save(person);
	}


	//FindAllBYId(1,2,3,4,5,6,)
	//select * from person where person_id in (1,2,3,4,5,6,)

	public Iterable<Person> getPersons(Iterable<Integer> personIds){

		return personDao.findAllById(personIds);

	}


	public Iterable<Person> findByLastName(String lastName){
		return personDao.findByLastName(lastName);
	}

	public Person findByLastNameAndFirstName(String lastName,String firstName) {
		return personDao.findByLastNameAndFirstName(lastName,firstName);
	}

	public Iterable<Person> findByLastNameOrFirstName(String lastName,String firstName){
		return personDao.findByLastNameOrFirstName(lastName,firstName);
	}
	 public Iterable<Person> findByLastNameOrderByCreatedDateDesc(String lastName){
		return personDao.findByLastNameOrderByCreatedDateDesc(lastName);
	}

	 public Iterable<Person> findByAgeLessThanEqual(Integer age){
		 return personDao.findByAgeLessThanEqual(age);
	 }
	 public List<Person> findByFirstNameLike(String firstName){
		 return personDao.findByFirstNameLike(firstName);
	 }

	 public List<Person> findByLastNameAndAgeLessThanEqual(String lastName,int age){
		 return personDao.findByLastNameAndAgeLessThanEqual(lastName,age);
	 }

	 public List<Person> findByCreatedDateBetween(Date startdate,Date endDate){
		 return personDao.findByCreatedDateBetween(startdate,endDate);
	 }


	 public Iterable<Book> saveAllBooks(Iterable<Book> booksList){
		 return bookDao.saveAll(booksList);
	 }

	 public Iterable<Book> getAllBooks(){

		 //bookDao.findAll ==> select id,name from book ;
		 return bookDao.findAll();
	 }

	 public List<Person> fetchDataWithName(String firstName){
		 return personDao.fetchDataWithName(firstName);
	 }


	 public Iterable<Book> fetchBookByName(String bookName){
		 return bookDao.fetchBookByName(bookName);
	 }



	public Iterable<Employee> saveAllEmployees(List<Employee> empList) {
		return empDao.saveAll(empList);
	}


	public List<Object[]> findMaxSalariesByDept(List<String> deptNames){
		return empDao.findMaxSalariesByDept(deptNames);
	}


	public List<CustomType> fetchFewColumns(String firstName){
		return personDao.fetchFewColumns(firstName);
	}

	public List<Person> findPersonInfobyFirstNameorEmail(String firstName,String email){
		return personDao.findPersonInfobyFirstNameorEmail(firstName,email);
	}

	public List<Person> findPersonINfobyFirstname(String firstName){
		return personDao.findPersonINfobyFirstname(firstName);
	}

	//Pagination

	public List<Person> findByLastName(String lastName, PageRequest pageRequest) {
		return personDao.findByLastName(lastName, pageRequest);
	}


	public List<Person> findByEmail(String email){
		System.out.println("Synch Method");
		return personDao.findByEmail(email);
	}

	public CompletableFuture<Person> findByemail(String email){
		System.out.println("Asynh Method");
		return personDao.findByemail(email);
	}
}
