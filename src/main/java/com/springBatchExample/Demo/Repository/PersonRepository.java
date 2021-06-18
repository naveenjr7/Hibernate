package com.springBatchExample.Demo.Repository;

import java.util.ArrayList;
import java.util.HashMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.springBatchExample.Demo.Model.Address;
import com.springBatchExample.Demo.Model.Company;
import com.springBatchExample.Demo.Model.Person;
import com.springBatchExample.Demo.Model.PersonName;

public class PersonRepository {

	public static void main(String[] args) {
		System.out.println("entereed");
		Configuration conf = new Configuration().configure().addAnnotatedClass(Person.class)
				.addAnnotatedClass(Company.class);
		SessionFactory factory = conf.buildSessionFactory();
		PersonName name = new PersonName("Naveen", null, "Chidamabaram");
		Person p = new Person(name, "Male", "nchidambaram3@gmail.com", 21);
		Company company = new Company(9, "Intellect", new Address(1, "first", "sipcot", "tn", "In", "600119"));
		company.setPerson(new ArrayList<>());
		company.getPerson().add(p);
		p.setCompany(company);
		p.setId(1);
		Session session = factory.openSession();
		// Session session = beanConfiguration().openSession();
		Transaction tx = session.beginTransaction();
		// System.out.println((String) session.createNativeQuery("select
		// version()").getSingleResult());
		// session.save(company);
		// session.save(p);
		Person p1 = session.get(Person.class, (long) 5);
		System.out.println("Person values is" + p1);
		if (p1 != null) {
			p1.setAge(66);
			session.update(p1);
		}
		tx.commit();
	}

	public static SessionFactory beanConfiguration() {
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		HashMap<String, String> dbSettings = new HashMap<>();
		dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate");
		dbSettings.put(Environment.USER, "root");
		dbSettings.put(Environment.PASS, "root");
		dbSettings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
		builder.applySettings(dbSettings);
		StandardServiceRegistry registry = builder.build();
		MetadataSources sources = new MetadataSources(registry);
		Metadata metaData = sources.getMetadataBuilder().build();
		return metaData.getSessionFactoryBuilder().build();

	}
}
