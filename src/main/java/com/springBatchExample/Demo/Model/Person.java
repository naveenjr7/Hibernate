package com.springBatchExample.Demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

@Entity(name = "persontest")
@DynamicUpdate
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	// @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
	PersonName personName;
	@Transient
	String Gender;
	@Column(name = "emailAddress", length = 50, unique = true, nullable = false)
	String email;
	int age;
	@ManyToOne
	@JoinColumn(name = "ADDR_ID", referencedColumnName = "ID")
	Company company;

	public Person() {
	}

	public Person(PersonName personName, String gender, String email, int age) {
		super();
		this.personName = personName;
		Gender = gender;
		this.email = email;
		this.age = age;
		String s=new String("Nfd");
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PersonName getPersonName() {
		return personName;
	}

	public void setPersonName(PersonName personName) {
		this.personName = personName;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", personName=" + personName + ", Gender=" + Gender + ", email=" + email + ", age="
				+ age + "]";
	}

}
