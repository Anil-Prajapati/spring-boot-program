package com.nareshit.ticketbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.ticketbooking.dao.TicketDao;
import com.nareshit.ticketbooking.model.Ticket;

@Service

// All transaction related capabilities and connecting to external frameworks will be done at
//service layer ==> Service layer is created with @service

//@Service ==> @Component + Service Layer functionality

//@Component ==> A SPRING CLASS WHICH MOVES TO IOC CONTAINER
public class TicketService {


	//TicketDao ticketdao=new TicketDao();
	//TicketDao ticketDao=ioc.getTicketDao(); //Spring based approach

	@Autowired
	private TicketDao ticketDao;    //Spring Boot Approach




	//retrive ticket


		//Retrieve All Tickets

		public Iterable<Ticket> getAllTickets(){

			return ticketDao.findAll();

			//findAll ==> select * from tbl_ticket ==> List< Result Set > Converted into Iterable<Ticket>
			//Resultset will converted into Java Class
		}


	    //Retrieve Specific Ticket

		public Ticket getTicket(Integer ticketId) {

			//findById ==> Retrieve Specific Record
			// Ouput of findById ==> Optional<Entity>

			return ticketDao.findById(ticketId).   //Ticket Object will be returned
							orElse(new Ticket());   //Dummy Ticket Object will be returned

		}


	//Create Ticket

		public Ticket createTicket(Ticket ticketObj) {

			//save is the method for inserting and updating record

			return ticketDao.save(ticketObj);
			//save ==> insert into tbl_ticket values(ticketObj.getPassenger...,ticet....tic....);

			//If ticketObj.getTicketId ==> 100 --> Insert
			// If ticketObj.getTicketId ==> null ==> insert

			//If ticketObj.getTicketid ==> 1 ==> Exists in the database ==> update
		}


		//delete ticket

		public void deleteTicket(Integer ticketId) {
			//deleteById ==> delete from tbl_ticket where ticket_id=ticketId

			ticketDao.deleteById(ticketId);
		}


	//update ticket

//We want to update only email Id

		public Ticket updateTicket(Integer ticketId,String newEmail) {

			//For Update ==> CRUD REPOSITORY ==> SAVE

			//Id ==> primary key should be available in database

			Ticket dbTicketObj=getTicket(ticketId); //Ticket Databaserow with ticketId

			dbTicketObj.setEmail(newEmail);

			return ticketDao.save(dbTicketObj);


		}









}
