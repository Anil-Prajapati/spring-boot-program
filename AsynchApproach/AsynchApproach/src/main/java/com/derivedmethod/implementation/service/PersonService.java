package com.derivedmethod.implementation.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.derivedmethod.implementation.dao.EmployeeRepositoryDAO;
import com.derivedmethod.implementation.dao.PersonDao;
import com.derivedmethod.implementation.model.Employee;
import com.derivedmethod.implementation.model.Person;

@Service
public class PersonService {
	


	@Autowired
	private PersonDao personDao;
	
	@Autowired
	private EmployeeRepositoryDAO empDao;
	

	
	
	public List<Person> findByFirstName(String firstName) {
		return personDao.findByFirstName(firstName);
	}

	public Person findByFirstNameAndLastName(String firstName, String lastName) {
		return personDao.findByFirstNameAndLastName(firstName, lastName);
	}

	public List<Person> findByFirstNameOrLastName(String firstName, String lastName) {
		return personDao.findByFirstNameOrLastName(firstName, lastName);
	}

	public List<Person> findByAgeLessThanEqual(Integer age) {
		return personDao.findByAgeLessThanEqual(age);
	}

	public List<Person> findByLastNameOrderByCreatedDateDesc(String lastName) {
		return personDao.findByLastNameOrderByCreatedDateDesc(lastName);
	}

	
	public Person findById(Integer personId) {
		return personDao.findById(personId).orElse(new Person());
	}
	
	//SaveAll -> Which will save Iterable<Person> as input. Will be saved to db in one JPA Call
	public Iterable<Person> savePersonsData(List<Person> personList) {
		return personDao.saveAll(personList);
	}

	
	//findAllById -> Which will form In operator in database and one query will get our data
	public Iterable<Person> findPersonsById(List<Integer> personList) {
		return personDao.findAllById(personList);
	}

	public Iterable<Person> findByFirstNameLike(String firstName) {
		return personDao.findByFirstNameLike(firstName);
	}
	
	
	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName,int age)
	{
		return personDao.findByLastNameAndAgeLessThanEqual(lastName,age);
	}
	
	public List<Person> findByCreatedDateBetween(Date startdate,Date endDate)
	{
		return personDao.findByCreatedDateBetween(startdate,endDate);
	}

	public Iterable<Employee> createEmployees(List<Employee> empList) {
		return empDao.saveAll(empList);
	}

	public List<Object[]> findMaxSalariesByDept(List<String> deptNames) {
		return empDao.findMaxSalariesByDept(deptNames);
	}

	public List<Person> findByLastName(String lastName, PageRequest pageRequest) {
		return personDao.findByLastName(lastName, pageRequest);
	}

	
	public List<Person> findByEmail(String email) {
		return personDao.findByEmail(email);
	}

	public CompletableFuture<Person> findByemail(String email) {
		
		return personDao.findByemail(email);
	}
	
}
