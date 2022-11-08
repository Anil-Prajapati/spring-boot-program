package com.derivedmethod.implementation.model;

public class CustomType {
	
	private String firstName;
	private String lastName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public CustomType(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "CustomType [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
