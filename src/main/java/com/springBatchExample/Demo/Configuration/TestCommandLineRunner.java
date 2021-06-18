package com.springBatchExample.Demo.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestCommandLineRunner implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(TestCommandLineRunner.class);

	public void run(String args[]) throws Exception {
		System.out.println("Entered the runner");
	}

}
