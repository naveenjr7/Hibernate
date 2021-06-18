package com.springBatchExample.Demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions.*;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.springBatchExample.Demo.Service.PersonService;

@SpringBootTest
class DemoApplicationTests {

	PersonService service = new PersonService();

	@Test
	void testService() {
		int result = service.sum(4, 4);
		// Assertions.assertEquals(10, result);
		assertThat("naveeen").isEqualTo("test");
	}

}
