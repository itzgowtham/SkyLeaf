package com.jspiders.skyleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.skyleaf.beans.BillingDetails;
import com.jspiders.skyleaf.repository.BillingDetailsRepository;

@RestController
@RequestMapping("/billing")
public class BillingDetailsController {
	@Autowired
	private BillingDetailsRepository repository;
	
	@GetMapping("/readAll")
	public Iterable<BillingDetails> readAll()
	{
		Iterable<BillingDetails> all=repository.findAll();
		return all;
	}
	
}
