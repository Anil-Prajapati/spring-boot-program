package com.nareshit.derivedmethods;

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

import com.nareshit.derivedmethods.model.Book;
import com.nareshit.derivedmethods.model.CustomType;
import com.nareshit.derivedmethods.model.Employee;
import com.nareshit.derivedmethods.model.Person;
import com.nareshit.derivedmethods.model.Publisher;
import com.nareshit.derivedmethods.service.PersonService;

@SpringBootApplication
@EnableAsync
public class DerivedMethodsExampleApplication implements CommandLineRunner {

	@Autowired
	private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(DerivedMethodsExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// createPersons();
		//getPersons();
		//findByLastName();
		//findByLastAndFirstNameName();
		//findByLastNameOrFirstName();
		//findByLastNameOrderByCreatedDateDesc();
		//findByAgeLessThanEqual();
		//findByFirstNameLike();
		///findByLastNameAndAgeLessThanEqual();
		//findByCreatedDateBetweenwithTime();
		//saveBookPublishers();
		//fetchDataWithName();
		//getBookDetails();
		//createEmployees();
		//findMaxSalariesbyDept();

		//fetchFewColumns();

		//findPersonInfobyFirstNameorEmail(); //query

		//findPersonINfobyFirstname(); //Native Query

		//dispPagination();
		//runsync();
		//runAsync();
		dynamicUpdateTest();
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

	private void dynamicUpdateTest() {

		Person dbPerson = personService.findByLastNameAndFirstName("kumar","Ram");


		dbPerson.setEmail("kumar@gmail.com");

		Person newData=personService.savePerson(dbPerson);

		System.out.println("Person Object" + newData.toString());

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
		CompletableFuture<Person> obj1 = personService.findByemail("kiran1@gmail.com");
		System.out.println("Person1 Call Done");

		CompletableFuture<Person> obj2 = personService.findByemail("laxmikiran1@gmail.com");
		System.out.println("Person2 Call Done");

		CompletableFuture<Person> obj3 = personService.findByemail("sita1@gmail.com");
		System.out.println("Person3 Call Done");

		CompletableFuture<Person> obj4 = personService.findByemail("lakshman2@gmail.com");
		System.out.println("Person4 Call Done"); //This work given to Thrad4  by Main Thread

		///
	 //	1000 lines of code

		//obj2




		// Wait until they are all done
		CompletableFuture.allOf(obj1, obj2, obj3, obj4).join();

		// Print results, including elapsed time

		System.out.println("--> " + obj1.get());
		System.out.println("--> " + obj2.get());
		System.out.println("--> " + obj3.get());
		System.out.println("--> " + obj4.get());

		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
	}

	private void dispPagination()
	{

		/*
		System.out.println("Pagination Without Sorting");

		List<Person> noSortList = personService.findByLastName("kumar",
				PageRequest.of(0, 4));
		//SELECT * FROM PERSON WHERE LAST_NAME='kumar' WHERE ROWNUMBER>=0 AND RWONUMBER<=4


		noSortList.forEach(System.out::println);

		 */



		System.out.println("First Page ------------------------");
		List<Person> list = personService.findByLastName("kumar",
				PageRequest.of(0, 4, Direction.ASC,"firstName"));

		//SELECT * FROM PERSON WHERE LAST_NAME='kumar' WHERE ROWNUMBER>=0 AND RWONUMBER<=4
		 //ORDER BY FIRSTAME ASC;

		//0 -> Offset
		//3 -> Page Size
		//Order of Sorting ASC/DESC
		//Which column Name order

		//for (Person person : list) {
		//	System.out.println("Person Object" + person.toString());
		//}

		list.forEach(System.out::println);


		System.out.println("Second Page ------------------------");
		List<Person> secondlist = personService.findByLastName("kumar",
				//new PageRequest(1, 2, Direction.ASC, "firstName"));
				PageRequest.of(1,4, Direction.ASC, "firstName"));

		secondlist.forEach(System.out::println);


		System.out.println("Third Page ------------------------");
		List<Person> thirdlist = personService.findByLastName("kumar",
				PageRequest.of(2, 3, Direction.ASC,"firstName"));

		thirdlist.forEach(System.out::println);


		System.out.println("Fourth Page ------------------------");
		List<Person> fourthList = personService.findByLastName("kumar",
				PageRequest.of(3, 3, Direction.ASC,"firstName"));

		fourthList.forEach(System.out::println);


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


	public void fetchFewColumns(){
		Iterable<CustomType> personsList = personService.fetchFewColumns("Kiran");
		for (CustomType person : personsList) {
			System.out.println("Person Object" + person.toString());

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

				//HT Dept
				Employee.create("Swathi", "HR", 80000),
				Employee.create("Sneha", "HR", 65000)

		);

		Iterable<Employee> list = personService.saveAllEmployees(empList);
		for (Employee emp : list) {
			System.out.println("Employee Object" + emp.toString());

		}
	}

	private void getBookDetails() {
		//select * from book join book_publisher join publisher on book.id=book_publisher.book_id
		// and publisher.id=book_publisher.publisher_id where book.id=4
		Iterable<Book> bookList = personService.fetchBookByName("Book2");
		for (Book book : bookList) {
			System.out.println("Book Object" + book.toString());
		}
	}

	public void fetchDataWithName(){
		Iterable<Person> personsList = personService.fetchDataWithName("Kiran");
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
		Book bookD=new Book("Book2",new HashSet<>(Arrays.asList(publisherD, publisherE)));
		Book bookE=new Book("Book5",new HashSet<>(Arrays.asList(publisherF)));
		Book bookF=new Book("Book6",new HashSet<>(Arrays.asList(publisherF)));


		 personService.saveAllBooks(Arrays.asList(bookA, bookB,bookC,bookD,bookE,bookF));

		// bookService.saveBooks(Arrays.asList(bookA, bookB));

		// fetch all publishers
		for (Book book : personService.getAllBooks()) {
			System.out.println(book.toString());
		}

	}

/*
	private void getBookDetails() {
		//select * from book join book_publisher join publisher on book.id=book_publisher.book_id
		// and publisher.id=book_publisher.publisher_id where book.id=4
		List<Book> bookList = bookDao.findAllBookBybookId(4);
		for (Book book : bookList) {
			System.out.println("Book Object" + book.toString());
		}
	}
*/

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

		List<Person> personList = Arrays.asList(
				new Person("Kiran", "kumar", "kiran@gmail.com", 20),
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

	private void findByLastName() {
		Iterable<Person> personsList = personService.findByLastName("kumar");
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}


	private void findByLastAndFirstNameName() {
		Person person = personService.findByLastNameAndFirstName("kumar","Ram");
		System.out.println("Person Object" + person.toString());
		/*
		 * for (Person person : personsList) { System.out.println("Person Object" +
		 * person.toString());
		 *
		 * }
		 */
	}


	private void findByLastNameOrFirstName() {
		Iterable<Person> personsList = personService.findByLastNameOrFirstName("kumar","Ram");
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}







	private void findByLastNameOrderByCreatedDateDesc() {
		Iterable<Person> personsList = personService.findByLastNameOrderByCreatedDateDesc("kumar");
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}

	public void findByAgeLessThanEqual(){
		Iterable<Person> personsList = personService.findByAgeLessThanEqual(30);
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}


	public void findByFirstNameLike(){
		Iterable<Person> personsList = personService.findByFirstNameLike("%Kiran%");
		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}
	}


	public void findByLastNameAndAgeLessThanEqual() {
		Iterable<Person> personsList = personService.findByLastNameAndAgeLessThanEqual("kumar",30);
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
		//2021-10-18 21:57:03
		Iterable<Person> personsList = personService.findByCreatedDateBetween(
				getDatewithTime("2021-12-20 07:32:12"),
				getDatewithTime("2021-12-20 07:32:18"));

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}


	private void findByCreatedDateBetween() {
		Iterable<Person> personsList = personService.findByCreatedDateBetween(
				getDate("2021-10-17"),
				getDate("2021-10-17"));

		for (Person person : personsList) {
			System.out.println("Person Object" + person.toString());

		}

	}


}
