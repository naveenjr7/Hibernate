package com.springBatchExample.Demo.Model;

import javax.persistence.Embeddable;

@Embeddable
public class PersonName {
	String firstName;
	String middleName;
	String LastName;

	public PersonName() {
		// TODO Auto-generated constructor stub
	}

	public PersonName(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		LastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@Override
	public String toString() {
		return "PersonName [firstName=" + firstName + ", middleName=" + middleName + ", LastName=" + LastName + "]";
	}

}
