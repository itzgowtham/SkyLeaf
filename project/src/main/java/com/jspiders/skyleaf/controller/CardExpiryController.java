package com.jspiders.skyleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.skyleaf.beans.CardExpiry;
import com.jspiders.skyleaf.repository.CardExpiryRepository;

@RestController
@RequestMapping("/cardexpiry")
public class CardExpiryController {
	@Autowired
	private CardExpiryRepository repository;
	
	@GetMapping("/readAll")
	public Iterable<CardExpiry> readAll()
	{
		Iterable<CardExpiry> all=repository.findAll();
		return all;
	}	
}
