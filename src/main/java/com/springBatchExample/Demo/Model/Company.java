package com.springBatchExample.Demo.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity()
public class Company {
	@Id
	int id;
	String name;
	Address address;
	@OneToMany(mappedBy = "company")
	List<Person> person;

	public Company() {
		// TODO Auto-generated constructor stub
	}

	public Company(int id, String name, Address address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public List<Person> getPerson() {
		return person;
	}

	public void setPerson(List<Person> person) {
		this.person = person;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}
