package com.derivedmethod.implementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.hibernate.type.CustomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.derivedmethod.implementation.dao.BookDao;
import com.derivedmethod.implementation.dao.PersonDao;
import com.derivedmethod.implementation.model.Book;
import com.derivedmethod.implementation.model.Employee;
import com.derivedmethod.implementation.model.Person;
import com.derivedmethod.implementation.model.Publisher;
import com.derivedmethod.implementation.service.PersonService;

@SpringBootApplication
@EnableAsync
public class DerivedMethodImplementationApplication implements CommandLineRunner {

	@Autowired
	private PersonService personService;

	@Autowired
	private PersonDao personDao;

	@Autowired
	private BookDao bookDao;

	public static void main(String[] args) {
		SpringApplication.run(DerivedMethodImplementationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// createPersons();
		// getPersonByIds();
		// findByFirstName();
		// findByFirstNameAndLastName();
		// findByFirstNameOrLastName();
		// findByLastNameOrderByCreationDateDesc();
		// findByAgeLessThanEqual();
		// findByFirstNameLike();
		// findByLastNameAndAgeLessThanEqual();
		// findByCreatedDateBetweenwithTime();
		// findByCreatedDateBetween();
		// searchpersonbyLastname();
		// searchbybothnames();
		// saveBookPublishers();
		// getBookDetails();
		// createEmployees();
		// findMaxSalariesbyDept();
		// givefewcolumns();
		// findPersonInfobyFirstNameorEmail();
		// findPersonINfobyFirstname();
		// dispPagination();
		//runsync();
		runAsync();

	}
	
	@Bean("asyncthreadpool")
	public TaskExecutor getAsyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(3);
		executor.setWaitForTasksToCompleteOnShutdown(false);
		executor.setThreadNamePrefix("AsyncThread-");
		System.out.println("Async Thread Pool Log");
		return executor;

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
		 */

		List<Person> personList = Arrays.asList(new Person("Kiran", "kumar", "kiran@gmail.com", 20),
				new Person("Ram", "kumar", "ram@gmail.com", 22),
				new Person("RamKiran", "LaxmiKiran", "sita@gmail.com", 30),
				new Person("Lakshamn", "Seth", "seth@gmail.com", 50),
				new Person("Sita", "Kumar", "lakshman@gmail.com", 50),
				new Person("Ganesh", "Kumar", "ganesh@gmail.com", 50),
				new Person("KiranKiran", "kumar", "kiran@gmail.com", 20),
				new Person("RamRam", "kumar", "ram@gmail.com", 22),
				new Person("RamKiranRamKiran", "LaxmiKiran", "sita@gmail.com", 30),
				new Person("RamKiranRamKiran", "Seth", "seth@gmail.com", 50),
				new Person("SitaSita", "Kumar", "lakshman@gmail.com", 50),
				new Person("GaneshSita", "Kumar", "ganesh@gmail.com", 50));

		Iterable<Person> list = personService.savePersonsData(personList);
		for (Person person : list) {
			System.out.println("Person Object" + person.toString());

		}
	}

	private void getPersonByIds() {
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
		Iterable<Person> personsList = personService.findPersonsById(personList);
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
		Person person = personService.findByFirstNameAndLastName("Ram", "kumar");

		System.out.println("Person Object" + person.toString());

	}

	// findByFirstNameAndLastName

	private void findByFirstNameOrLastName() {
		Iterable<Person> personsList = personService.findByFirstNameOrLastName("Sita", "kumar");

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	// findByLastNameOrderByCreationDateDesc
	private void findByLastNameOrderByCreationDateDesc() {
		Iterable<Person> personsList = personService.findByLastNameOrderByCreatedDateDesc("kumar");

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	// findByAgeLessThanEqual

	private void findByAgeLessThanEqual() {
		Iterable<Person> personsList = personService.findByAgeLessThanEqual(40);

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	private void findByLastNameAndAgeLessThanEqual() {
		Iterable<Person> personsList = personService.findByLastNameAndAgeLessThanEqual("kumar", 40);

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

	private Date getDatewithTime(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		try {
			return format.parse(dateString);
		} catch (ParseException pe) {
			throw new RuntimeException(pe);
		}
	}

	private Date getDate(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			return format.parse(dateString);
		} catch (ParseException pe) {
			throw new RuntimeException(pe);
		}
	}

	private Date getDate(String dateString, int add) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date current = format.parse(dateString);

			Calendar cal = Calendar.getInstance();
			cal.setTime(current);
			cal.add(Calendar.DATE, add);

			return cal.getTime();
		} catch (ParseException pe) {
			throw new RuntimeException(pe);
		}
	}

	private void findByCreatedDateBetweenwithTime() {
		// 2020-05-22 07:43:51.175000
		Iterable<Person> personsList = personDao.findByCreatedDateBetween(getDatewithTime("2020-05-22 07:43:00"),
				getDatewithTime("2020-05-22 07:43:52"));

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	private void findByCreatedDateBetween() {
		Iterable<Person> personsList = personDao.findByCreatedDateBetween(getDate("2020-05-10"), getDate("2020-05-23"));

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	private void searchpersonbyLastname() {
		Iterable<Person> personList = personDao.searchpersonbyLastname("kumar");

		for (Person person : personList) {
			System.out.println(person.toString());
		}
	}

	private void searchbybothnames() {
		Person person = personDao.searchbybothnames("Kumar", "Sita");

		System.out.println(person.toString());

	}

	private void saveBookPublishers() {

		Publisher publisherA = new Publisher("AbdulKalam");
		Publisher publisherB = new Publisher("Stephen Kovey");
		Publisher publisherC = new Publisher("ChetanBagath");
		Publisher publisherD = new Publisher("Nazeer");
		Publisher publisherE = new Publisher("Sahoo");

		Book bookA = new Book("WingsofFire", new HashSet<>(Arrays.asList(publisherA)));
		Book bookB = new Book("SevenHabits", new HashSet<>(Arrays.asList(publisherB)));
		Book bookC = new Book("TwoStates", new HashSet<>(Arrays.asList(publisherC)));
		Book bookD = new Book("NewBook", new HashSet<>(Arrays.asList(publisherD, publisherE)));

		bookDao.saveAll(Arrays.asList(bookA, bookB, bookC, bookD));
		// bookService.saveBooks(Arrays.asList(bookA, bookB));

		// fetch all publishers
		for (Book book : bookDao.findAll()) {
			System.out.println(book.toString());
		}

	}

	private void getBookDetails() {
		List<Book> bookList = bookDao.findAllBookBybookId(4);
		for (Book book : bookList) {
			System.out.println("Book Object" + book.toString());
		}
	}

	private void createEmployees() {
		List<Employee> empList = Arrays.asList(Employee.create("Ram", "Admin", 2000),
				Employee.create("Gopi", "Admin", 3500),

				Employee.create("Sita", "Sale", 1000), Employee.create("Ganesh", "Sale", 3000),

				Employee.create("Laxman", "IT", 4000), Employee.create("Seenu", "IT", 2500));

		Iterable<Employee> list = personService.createEmployees(empList);
		for (Employee emp : list) {
			System.out.println("Employee Object" + emp.toString());

		}
	}

	private void findMaxSalariesbyDept() {
		System.out.println(" -- finding max salaries in Admin and IT depts  --");
		List<Object[]> list = personService.findMaxSalariesByDept(Arrays.asList("Admin", "IT", "Sale"));
		list.forEach(arr -> {
			System.out.println(Arrays.toString(arr));
		});
	}

	private void givefewcolumns() {
		List<com.derivedmethod.implementation.model.CustomType> personList = personDao.givefewcolumns("kumar");

		for (com.derivedmethod.implementation.model.CustomType person : personList) {
			System.out.println(person.toString());
		}
	}

	private void findPersonInfobyFirstNameorEmail() {
		Iterable<Person> personsList = personDao.findPersonInfobyFirstNameorEmail("Sita", "ganesh@gmail.com");

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	private void findPersonINfobyFirstname() {
		Iterable<Person> personsList = personDao.findPersonINfobyFirstname("Sita");

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}

	private void dispPagination() {

		System.out.println("First Page Without sorting ------------------------");
		List<Person> noSortList = personService.findByLastName("kumar", PageRequest.of(0, 4));

		noSortList.forEach(System.out::println);

		System.out.println("First Page ------------------------");
		List<Person> list = personService.findByLastName("kumar", PageRequest.of(0, 4, Direction.ASC, "firstName"));

		// SELECT * FROM PERSON WHERE LAST_NAME=? WHERE ROWNUMBER>=0 AND RWONUMBER<=2
		// ORDER BY FIRSTAME ASC;

		// 0 -> Offset
		// 4 -> Page Size
		// Order of Sorting ASC/DESC
		// Which column Name order

		// for (Person person : list) {
		// System.out.println("Person Object" + person.toString());
		// }

		list.forEach(System.out::println);

		System.out.println("Second Page ------------------------");
		List<Person> secondlist = personService.findByLastName("kumar",
				// new PageRequest(1, 2, Direction.ASC, "firstName"));
				PageRequest.of(1, 4, Direction.ASC, "firstName"));

		secondlist.forEach(System.out::println);

		System.out.println("Third Page ------------------------");
		List<Person> thirdlist = personService.findByLastName("kumar",
				PageRequest.of(2, 4, Direction.ASC, "firstName"));

		thirdlist.forEach(System.out::println);

		System.out.println("Fourth Page ------------------------");
		List<Person> fourthList = personService.findByLastName("kumar",
				PageRequest.of(3, 4, Direction.ASC, "firstName"));

		fourthList.forEach(System.out::println);

	}

	private void runsync() throws InterruptedException, ExecutionException {

		long start = System.currentTimeMillis();
		// Kick of multiple, asynchronous lookups
		List<Person> person1 = personService.findByEmail("kiran@gmail.com");
		// The following statement will be printed only after the
		// execution of above method findByEmail
		System.out.println("Person1 Call Completed");

		List<Person> personson2 = personService.findByEmail("laxmikiran@gmail.com");
		System.out.println("Person2 Call Completed");

		List<Person> personson3 = personService.findByEmail("sita@gmail.com");
		System.out.println("personson3 Call Completed");

		List<Person> personson4 = personService.findByEmail("lakshman@gmail.com");
		System.out.println("personson4 Call Completed");
		;

		// Wait until they are all done
		// Print results, including elapsed time

		person1.forEach(System.out::println);
		personson2.forEach(System.out::println);

		personson3.forEach(System.out::println);

		personson4.forEach(System.out::println);

		System.out.println("Total Time took: " + (System.currentTimeMillis() - start));

	}

	private void runAsync() throws InterruptedException, ExecutionException {
		long start = System.currentTimeMillis();
		// Kick of multiple, asynchronous lookups

		// main Thread is executing the runAsynch method
		CompletableFuture<Person> obj1 = personService.findByemail("kiran@gmail.com");
		System.out.println("obj1 Call");

		CompletableFuture<Person> obj2 = personService.findByemail("laxmikiran@gmail.com");
		System.out.println("Obj2 Call");

		CompletableFuture<Person> obj3 = personService.findByemail("sita@gmail.com");
		System.out.println("Obj3 Call");

		CompletableFuture<Person> obj4 = personService.findByemail("lakshman@gmail.com");
		System.out.println("Obj4 Call");

		// Wait until they are all done
		CompletableFuture.allOf(obj1, obj2, obj3, obj4).join();
		
		// Print results, including elapsed time
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		System.out.println("--> " + obj1.get());
		System.out.println("--> " + obj2.get());
		System.out.println("--> " + obj3.get());
		System.out.println("--> " + obj4.get());
	}
}
