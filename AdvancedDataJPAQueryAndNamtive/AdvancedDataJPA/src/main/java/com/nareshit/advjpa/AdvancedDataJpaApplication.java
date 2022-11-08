package com.nareshit.advjpa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nareshit.advjpa.model.Book;
import com.nareshit.advjpa.model.CustomType;
import com.nareshit.advjpa.model.Employee;
import com.nareshit.advjpa.model.Person;
import com.nareshit.advjpa.model.Publisher;
import com.nareshit.advjpa.service.PersonService;


@SpringBootApplication
public class AdvancedDataJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(AdvancedDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// createPersons();
		// getPersons();
		// findByFirstName();
		//findByFirstNameAndLastName();
		//findByFirstNameOrLastName();
		// findByLastNameOrderByCreationDateDesc();
		//findByAgeLessThanEqual();
		//findByFirstNameLike();
		//findByCreatedDateBetweenwithTime();
		//saveBookPublishers();
		//findByBookName();
		//giveDataByName();
		//fetchBookByName();
	//	createEmployees();
		//findMaxSalariesbyDept();
		//fetchFewColumns();
		findPersonInfobyFirstNameorEmail();
		findPersonINfobyFirstname();
	}


	private void findPersonInfobyFirstNameorEmail() {
		Iterable<Person> personsList = personService.findPersonInfobyFirstNameorEmail("Ram","ram@gmail.com");
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void findPersonINfobyFirstname() {
		Iterable<Person> personsList = personService.findPersonINfobyFirstname("Ram");
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void fetchFewColumns() {
		Iterable<CustomType> personsList = personService.fetchFewColumns("Ram");
		for (CustomType person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}


	private void createEmployees() {
		List<Employee> empList = Arrays.asList(
				//Admin Dept
				Employee.create("Ram", "Admin", 20000),
				Employee.create("Gopi", "Admin", 35000),

				//Sales Dept
				Employee.create("Sita", "Sale", 10000),
				Employee.create("Ganesh", "Sale", 30000),

				//IT Dept
				Employee.create("Laxman", "IT", 40000),
				Employee.create("Seenu", "IT", 25000),

				//HR Dept
				Employee.create("Swathi", "HR", 80000),
				Employee.create("Sneha", "HR", 65000)

		);

		Iterable<Employee> list = personService.saveAllEmployees(empList);
		for (Employee emp : list) {
			System.out.println("Employee Object" + emp.toString());

		}
	}

	private void findMaxSalariesbyDept() {

		List<Object[]> list = personService.findMaxSalariesByDept(
				Arrays.asList("Admin", "IT", "HR"));
		list.forEach(arr -> {
			System.out.println(Arrays.toString(arr));
		}
		);
	}


	private void giveDataByName() {
		Iterable<Person> personsList = personService.giveDataByName("Ram");
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}


	private void saveBookPublishers() {

		Publisher publisherA = new Publisher("AbdulKalam");
		Publisher publisherB = new Publisher("Stephen Kovey");
		Publisher publisherC = new Publisher("ChetanBagath");
		Publisher publisherD = new Publisher("Author2");
		Publisher publisherE = new Publisher("Author3");
		Publisher publisherF = new Publisher("Nazir");

		Book bookA = new Book("WingsofFire", new HashSet<>(Arrays.asList(publisherA)));
		Book bookB = new Book("SevenHabits", new HashSet<>(Arrays.asList(publisherB)));
		Book bookC = new Book("TwoStates", new HashSet<>(Arrays.asList(publisherC)));
		Book bookD = new Book("Book2", new HashSet<>(Arrays.asList(publisherD, publisherE)));
		Book bookE = new Book("Book5", new HashSet<>(Arrays.asList(publisherF)));
		Book bookF = new Book("Book6", new HashSet<>(Arrays.asList(publisherF)));

		personService.saveAllBooks(Arrays.asList(bookA, bookB, bookC, bookD, bookE, bookF));

		// bookService.saveBooks(Arrays.asList(bookA, bookB));

		// fetch all publishers
		for (Book book : personService.getAllBooks()) {
			System.out.println(book.toString());
		}

	}

	private void findByBookName() {
		Book book = personService.findByBookName("WingsofFire");
		System.out.println(book.toString());
	}



	private void fetchBookByName() {
		Iterable<Book> booksList = personService.fetchBookByName("Book2");
		for (Book book : booksList) {
			System.out.println(book.toString());
		}
	}


	private void createPersons() {

		/*
		 * List<Person> personList=new ArrayList<Person>();
		 *
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 *
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 *
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 * personList.add(new Person("Kiran", "kumar", "kiran@gmail.com", 20));
		 *
		 * personService.saveAllpersons(personList);
		 */

		List<Person> personList = Arrays.asList(new Person("Kiran", "kumar", "kiran@gmail.com", 20),
				new Person("Ram", "kumar", "ram@gmail.com", 22),
				new Person("RamKiran", "LaxmiKiran", "sita@gmail.com", 30),
				new Person("Lakshamn", "Seth", "seth@gmail.com", 50),
				new Person("Sita", "Kumar", "lakshman@gmail.com", 50),
				new Person("Ganesh", "Kumar", "ganesh@gmail.com", 50),
				new Person("KiranKiran", "kumar", "kiran@yahoo.com", 20),
				new Person("RamRam", "kumar", "ram@yahoo.com", 22),
				new Person("RamKiranRamKiran", "LaxmiKiran", "sita@yahoo.com", 30),
				new Person("RamKiranRamKiran", "Seth", "seth@yahoo.com", 50),
				new Person("SitaSita", "Kumar", "lakshman@yahoo.com", 50),
				new Person("GaneshSita", "Kumar", "ganesh@yahoo.com", 50));

		Iterable<Person> list = personService.saveAllPersons(personList);
		for (Person person : list) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void getPersons() {
		List<Integer> personList = new ArrayList<Integer>();
		personList.add(1);
		personList.add(2);
		personList.add(12);
		personList.add(5);
		personList.add(6);
		personList.add(20);
		personList.add(40);
		personList.add(11);
		personList.add(15);
		personList.add(3);
		personList.add(4);
		Iterable<Person> personsList = personService.getPersons(personList);
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void findByFirstName() {
		Iterable<Person> personsList = personService.findByFirstName("Ram");
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void findByFirstNameAndLastName() {
		Person person = personService.findByLastNameAndFirstName("kumar", "Ram");

		System.out.println("Person Object" + person.toString());

	}

	private void findByFirstNameOrLastName() {
		Iterable<Person> personsList = personService.findByLastNameOrFirstName("kumar", "Ram");

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	private void findByLastNameOrderByCreationDateDesc() {
		Iterable<Person> personsList = personService.findByLastNameOrderByCreatedDateDesc("kumar");

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}


	private void findByAgeLessThanEqual() {
		Iterable<Person> personsList = personService.findByAgeLessThanEqual(40);

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	private void findByFirstNameLike() {
		Iterable<Person> personList = personService.findByFirstNameLike("%Kiran%");

		for (Person person : personList) {
			System.out.println(person.toString());
		}
	}


	private void findByCreatedDateBetweenwithTime() {
		//2021-10-18 21:57:03
		Iterable<Person> personsList = personService.findByCreatedDateBetween(
				getDatewithTime("2022-07-24 21:29:18"),
				getDatewithTime("2022-07-25 21:29:19"));

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	private Date getDatewithTime(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			return format.parse(dateString);
		} catch (ParseException pe) {
			throw new RuntimeException(pe);
		}
	}


}
