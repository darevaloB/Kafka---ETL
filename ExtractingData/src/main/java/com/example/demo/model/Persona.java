package com.example.demo.model;

import java.util.List;

public class Persona {
	
	private List<String> records;
	
	   

	public Persona() {
		
	}

	public Persona(List<String> records) {
		super();
		this.records = records;
	}

	public List<String> getRecords() {
		return records;
	}

	public void setRecords(List<String> records) {
		this.records = records;
	}
	
	

}
