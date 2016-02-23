package com.projectManagement;

import org.hibernate.Session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
        	SpringApplication.run(Application.class, args);
	}

}
