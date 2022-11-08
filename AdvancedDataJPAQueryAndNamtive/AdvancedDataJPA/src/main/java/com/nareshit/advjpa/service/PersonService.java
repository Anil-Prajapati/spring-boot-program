package com.nareshit.advjpa.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.advjpa.dao.BookDao;
import com.nareshit.advjpa.dao.EmployeeDao;
import com.nareshit.advjpa.dao.PersonDao;
import com.nareshit.advjpa.model.Book;
import com.nareshit.advjpa.model.CustomType;
import com.nareshit.advjpa.model.Employee;
import com.nareshit.advjpa.model.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	@Autowired
	private BookDao bookDao;

	@Autowired
	private EmployeeDao empDao;

	public Iterable<Person> saveAllPersons(Iterable<Person> personsLIst) {
		return personDao.saveAll(personsLIst);
	}

	public Iterable<Person> getPersons(Iterable<Integer> personIds) {
		return personDao.findAllById(personIds);
	}
	public List<Person> findByFirstName(String firstName){
		return personDao.findByFirstName(firstName);
	}

	public Person findByLastNameAndFirstName(String lastName,String firstName) {
		return personDao.findByLastNameAndFirstName(lastName,firstName);
	}

	public List<Person> findByLastNameOrFirstName(String lastName,String firstName) {
		return personDao.findByLastNameOrFirstName(lastName,firstName);
	}

	public List<Person> findByLastNameOrderByCreatedDateDesc(String lastName){
		return personDao.findByLastNameOrderByCreatedDateDesc(lastName);
	}

	public List<Person> findByAgeLessThanEqual(Integer age){
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

	public Iterable<Book> saveAllBooks(Iterable<Book> booksData){
		return bookDao.saveAll(booksData);
	}

	public Iterable<Book> getAllBooks(){
		return bookDao.findAll();
	}

	public Book findByBookName(String bookName) {
		return bookDao.findByBookName(bookName);
	}

	public List<Person> giveDataByName(String firstName){
		return personDao.giveDataByName(firstName);
	}

	public Iterable<Book> fetchBookByName(String bookName){
		return bookDao.fetchBookByName(bookName);
	}

	public Iterable<Employee> saveAllEmployees(Iterable<Employee> empList){
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
}
