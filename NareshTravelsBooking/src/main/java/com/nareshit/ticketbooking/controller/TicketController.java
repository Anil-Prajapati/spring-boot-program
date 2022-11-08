package com.nareshit.ticketbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nareshit.ticketbooking.model.Ticket;
import com.nareshit.ticketbooking.service.TicketService;

@RestController //Entry Point  for all External FE's
@RequestMapping(value="/tickets")   ///http://localhost:8080/tickets

///http://localhost:8080/tickets ==> TicketController ticketController=ioc.getTicketController();
public class TicketController {


	//REST SERVICCES CONCEPT ==> ITS PART OF WEBSERICE PATTERN

	/*
	 *
	 * WebService ==> Heterogenious Systems Communication
	 *
	 * Webservices ==> 1) SOAP Based WebServices   and 2) REST Based Web Services
	 *
	 * Spring Boot supports only Rest Services
	 *
	 * JAX RS --- JAVA API FOR XML REST SERVICES
	 *
	 * REST SERVICE ==> REPRESENTATIONAL STATE TRANSFER
	 *
	 * MAINLY IT WORKS ON HTTP PROTOCOL
	 *
	 * JSON (JAVA SCRIPT OBJECT NOTATION) is the object can be understadable by every programming language
	 *
	 * JSON is the mode of communication for REST PROTOCOL
	 *
	 *
	 *   REST PROTOCOL SUPPORTS GET , POST , PUT AND DELETE VERBS FOR COMMUNICATION
	 *
	 *   GET ==> GET DATA ==> @Get + @RequestMapping ==> @GetMapping or @RequestMapping both are same
	 *
	 *   POST ==> CREATING DATA ==> @Post + + @RequestMapping  ==> @PostMapping
	 *
	 *   PUT ==> UPDATING DATA ==> @Put + + @RequestMapping  ==> @PutMapping
	 *
	 *   DELETE => DELETING DATA ==> Delete + + @RequestMapping  ==> @DeleteMapping
	 *
	 *
	 *
	 */


	@Autowired
	private TicketService ticketService;


	//RETRIEVE ALL TICKETS

	@GetMapping(value="/all") //http://localhost:8080/tickets/all
	//http://localhost:8080/tickets/all ==> ticketController.getAllTickets();
	public Iterable<Ticket> getAllTickets(){

		return ticketService.getAllTickets();

	}



	//RETRIEVE SINGLE TICKET

	//http://localhost:8080/tickets/1  => 1st Ticket
	//http://locahost:8080/tickets/2 ==> 2nd Ticket
	//http://localhost:8080/tickets/100 == > 100 th ticket
	@GetMapping(value="/{ticketId}")  //{ } Dynamic Varaiable in the URL
	//@PathVariable ==> Is going to read the dynamic parameter in the URL
	public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {
		return ticketService.getTicket(ticketId);
	}



	//CREATE TICKET

	@PostMapping(value="/create") //http://localhost:8080/tickets/create
	//http://localhost:8080/tickets/create==>ticketController.createTicket();
	//@RequestBody ==> It will point to the request where its exists in BODY section
	public Ticket createTicket(@RequestBody Ticket ticketObj) {
		return ticketService.createTicket(ticketObj);
	}

	//UPDATE TICKET

	//http://localhost:8080/tickets/1/a@b.com

	@PutMapping(value="/{ticketId}/{newEmail}")
	public Ticket updateTicket(
			@PathVariable("ticketId") Integer ticketId,
			@PathVariable("newEmail") String newEmail) {
		return ticketService.updateTicket(ticketId, newEmail);
	}


	//DELETE TICKET
	@DeleteMapping(value="/{ticketId}") //http://localhost:8080/tickets/1
	public void deleteTicket(@PathVariable("ticketId") Integer ticketId)
	{
		ticketService.deleteTicket(ticketId);
	}
}
