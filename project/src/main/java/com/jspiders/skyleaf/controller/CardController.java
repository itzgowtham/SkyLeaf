package com.jspiders.skyleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.skyleaf.beans.Card;
import com.jspiders.skyleaf.repository.CardRepository;

@RestController
@RequestMapping("/card")
public class CardController {
	@Autowired
	private CardRepository repository;
	
	@GetMapping("/readAll")
	public Iterable<Card> readAll()
	{
		Iterable<Card> all=repository.findAll();
		return all;
	}	
}
