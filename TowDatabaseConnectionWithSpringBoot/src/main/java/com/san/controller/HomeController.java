package com.san.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.san.entity1.Laptop;
import com.san.entity2.Customer;
import com.san.repository1.LaptopReposiroty;
import com.san.repository2.CustomerRepository;

@RestController
public class HomeController {

	@Autowired
	LaptopReposiroty laptopRepository;

	@Autowired
	CustomerRepository customerRepository;

	@PostConstruct
	public void addData2DB() {
		customerRepository
				.saveAll(Stream.of(new Customer(1001, "Akash"), new Customer(1002, "Amit")).collect(Collectors.toList()));
		laptopRepository
				.saveAll(Stream.of(new Laptop(1001, 57000, "Nokia PureBook"), new Laptop(1002, 60000, "Asus VivoNotebook 14"))
						.collect(Collectors.toList()));

	}

	@GetMapping("/getCustomer")
	public List<Customer> getCustomer() {
		return customerRepository.findAll();
	}

	@GetMapping("/getLaptop")
	public List<Laptop> getLaptop() {
		return laptopRepository.findAll();
	}

}
