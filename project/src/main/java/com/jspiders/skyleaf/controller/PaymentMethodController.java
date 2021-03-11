package com.jspiders.skyleaf.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.jspiders.skyleaf.beans.BillingDetails;
import com.jspiders.skyleaf.beans.Card;
import com.jspiders.skyleaf.beans.CardExpiry;
import com.jspiders.skyleaf.beans.PaymentMethod;
import com.jspiders.skyleaf.beans.ReturnLinks;
import com.jspiders.skyleaf.repository.BillingDetailsRepository;
import com.jspiders.skyleaf.repository.CardExpiryRepository;
import com.jspiders.skyleaf.repository.CardRepository;
import com.jspiders.skyleaf.repository.PaymentMethodRepository;
import com.jspiders.skyleaf.repository.ReturnLinksRepository;

@RestController
@RequestMapping("/paymentmethod")
public class PaymentMethodController {
	@Autowired
	private PaymentMethodRepository repository;
	
	@Autowired
	private BillingDetailsRepository billrepository;
	
	@Autowired
	private CardRepository cardrepository;
	
	@Autowired
	private CardExpiryRepository cardexpiryrepository;
	
	@Autowired
	private ReturnLinksRepository returnlinksrepository;
	
	@GetMapping("/readAll")
	public String readAll()
	{
		Iterable<PaymentMethod> all=repository.findAll();
		Gson gson=new Gson();
		String json = gson.toJson(all);
		
		JSONArray j1=new JSONArray(json); 
		JSONObject res=new JSONObject(j1.get(0).toString());
		
		Iterable<BillingDetails> billingResponse=billrepository.findAll();
		
		json=gson.toJson(billingResponse);
		JSONObject billingJson=new JSONObject(new JSONArray(json).get(0).toString());
		res.put("BillingDetails", billingJson);
		
		Iterable<Card> cardResponse=cardrepository.findAll();
		
		json=gson.toJson(cardResponse);
		JSONObject cardJson=new JSONObject(new JSONArray(json).get(0).toString());
		
		Iterable<CardExpiry> cardExpiry=cardexpiryrepository.findAll();
		
		json = gson.toJson(cardExpiry);
		JSONObject cardExpiryJson = new JSONObject(new JSONArray(json).get(0).toString());
		cardJson.put("CardExpiry", cardExpiryJson);
		
		res.put("Card", cardJson);
		
		Iterable<ReturnLinks> returnLink=returnlinksrepository.findAll();
		
		json = gson.toJson(returnLink);
//		JSONObject returnlinkJson = new JSONObject(new JSONArray(json).get(0).toString());
		
		res.put("Returnlinks", new JSONArray(json));
		return res.toString();
	}
	
	@PostMapping
	public PaymentMethod create(@RequestBody PaymentMethod payment)
	{
		return repository.save(payment);
	}
}
