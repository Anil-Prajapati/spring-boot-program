package com.nareshit.ticketbooking;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nareshit.ticketbooking.model.Ticket;
import com.nareshit.ticketbooking.service.TicketService;

@SpringBootApplication
public class NareshTravelsBookingApplication implements CommandLineRunner {


	/*
	 *
	 * CommandLineRunner is interface which is used for running a task only once during startup
	 * Mostly it is used for dumping static data. We should over ride run method
	 */

	@Autowired
	private TicketService ticketService;

	public static void main(String[] args) {
		SpringApplication.run(NareshTravelsBookingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		//Dummy Ticket ==> This will be executed Only once

		Ticket ticketObj=new Ticket();
		ticketObj.setPassengerName("RAMU");
		ticketObj.setSourceStation("HYDERABAD");
		ticketObj.setDestinationStation("GOA");
		ticketObj.setTravelDate(new Date());
		ticketObj.setEmail("ramu@gmail.com");

		ticketService.createTicket(ticketObj);

	}

}
