package com.springBatchExample.Demo.Processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.springBatchExample.Demo.Model.Person;

public class PersonProcessor implements ItemProcessor<Person, Person> {
	private static final Logger logger = LoggerFactory.getLogger(PersonProcessor.class);

	@Override
	public Person process(Person item) throws Exception {

		// Person transformedPerson = new Person(item.getId(), item.getPersonName(),
		// item.getGender(), item.getEmail(), item.getAge());
		Person transformedPerson = item;
		logger.info("Converting person object " + item + " into new object " + transformedPerson);
		return transformedPerson;
	}

}
