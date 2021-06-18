package com.springBatchExample.Service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.springBatchExample.Demo.Service.PersonService;

@RunWith(JUnitPlatform.class)
public class PersonServiceTest {
	PersonService service = new PersonService();

	@BeforeAll
	static void setup() {
		System.out.println("@BeforeAll executed");
	}

	@Test
	@DisplayName("My First TestCase")
	void testService() {
		System.out.println("entered");
		int result = service.sum(4, 4);
		Assertions.assertEquals(10, result);
	}
}
