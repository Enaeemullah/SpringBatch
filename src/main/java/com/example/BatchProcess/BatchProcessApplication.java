package com.example.BatchProcess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BatchProcessApplication {

	public static void main(String[] args) {
//		SpringApplication.run(BatchProcessApplication.class, args);
		System.exit(SpringApplication.exit(SpringApplication.run(BatchProcessApplication.class)));
	}

}
