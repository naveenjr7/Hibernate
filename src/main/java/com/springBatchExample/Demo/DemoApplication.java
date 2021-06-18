package com.springBatchExample.Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	static {
		System.out.println("acess");
	}
	{
		System.out.println("first");
	}

	public static void main(String[] args) {
		DemoApplication d = new DemoApplication();
		SpringApplication.run(DemoApplication.class, args);
		String s1 = "test";
		String s2 = new String("test");
		if (s1 == s2.intern())
			System.out.println("true");
		else
			System.out.println("false");
	}

}
