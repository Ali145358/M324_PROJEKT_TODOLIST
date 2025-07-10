package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is a demo application that provides a RESTful API for a simple ToDo list
 * without persistence.
 * The API is versioned and can be found in the TaskController.
 *
 * @author luh
 */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
