package com.nareshit.ticketbooking.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This class will be associated to database table. It will create a table in
		// the database
		// By default Class Name will the table Name

@Table(name = "tbl_ticket") // @Table is an optional Annotation which is used for creating custom table name
							// rather than class name
public class Ticket {

	@Id // This will be creating a primarykey for the column
	@Column(name = "ticket_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ticketId;

	/*
	 *
	 * AUTO ==> JPA FRAMEWORK WILL CREATE A DATABASE SEQUENCE AND IT WILL INCREMENT
	 * VALUE ON ITS OWN AND USES THIS VALUES AS PART OF PRIMARY KEY
	 *
	 *
	 */
	@Column(name = "passenger_name")
// A column will be created with column name as passenger_name
//@column is also an optional Entity
	private String passengerName;

	@Column(name = "travel_date")
	private Date travelDate;

	@Column(name = "source_station")
	private String sourceStation;

	@Column(name = "destination_station")
	private String destinationStation;

	private String email;

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Ticket(String passengerName, Date travelDate, String sourceStation, String destinationStation,
			String email) {
		super();
		this.passengerName = passengerName;
		this.travelDate = travelDate;
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		this.email = email;
	}

	public Ticket() {}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", passengerName=" + passengerName + ", travelDate=" + travelDate
				+ ", sourceStation=" + sourceStation + ", destinationStation=" + destinationStation + ", email=" + email
				+ "]";
	}






}
