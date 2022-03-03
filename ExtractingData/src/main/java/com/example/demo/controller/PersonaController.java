package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.service.DataService;

@RestController
public class PersonaController {
	
	@Autowired
	DataService service;
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	
	
	@GetMapping("/")
	public Persona postData() {
		
		List<String> fileData = service.getDataFromFile();
		
		for(String individualRecord : fileData){
			
			System.out.println(individualRecord);
			kafkaTemplate.send("source_topic", individualRecord);
			
	}
		
	return new Persona(fileData) ;
	}
}
