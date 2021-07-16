package com.san;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.san.repository1.LaptopReposiroty;
import com.san.repository2.CustomerRepository;

@SpringBootApplication
public class TowDatabaseConnectionApplication implements CommandLineRunner {
	@Autowired
	LaptopReposiroty lapRepo;
	
	@Autowired
	CustomerRepository cusRepo;

	public static void main(String[] args) {
		SpringApplication.run(TowDatabaseConnectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
  
	

}
