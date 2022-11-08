package com.nareshit.ticketbooking.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.ticketbooking.model.Ticket;

@Repository

//@Repository ==> It will create internally a database connection
  //With TicketDao ==> WE can directly work with Ticket Table
// No need to write any boiler plate code like DriverManager.getConnection(....)
//Connection.Open()..ResultSet,PreparedStatement,Execute Update,ExecuteSql
public interface  TicketDao extends CrudRepository<Ticket, Integer> {


	/*
	 *
	 * CRUD REPOSITORY ==> C ==> CREATE
	 *                     R ==> READ
	 *                     U ==> UPDATE
	 *                     D ==> DELETE
	 *
	 * THIS REPOSITORY CREATED BY SPRING BOOT FRAMEWORK FOR PERFORMING CRUD OPERATION. THIS IS
	 * GENERIC IMPLEMENTATION CAN BE APPLIED TO ALL TABLES
	 *
	 * INPUTS ===> 1) CLASS NAME
	 *             2) DATA TYPE OF PRIMARY KEY
	 */

}
