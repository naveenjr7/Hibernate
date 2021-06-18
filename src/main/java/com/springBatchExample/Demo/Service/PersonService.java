package com.springBatchExample.Demo.Service;

//import static org.assertj.core.api.Assertions.assertThat;

public class PersonService {

	int a, b;
	static int c;

	public int sum(int a, int b) {
		// assertThat("naveeen").isEqualTo("test");
		return a + b;
	}

	public static int sum(int a) {
		return a;
	}
}
