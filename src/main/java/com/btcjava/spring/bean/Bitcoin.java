package com.btcjava.spring.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bitcoin {

	private int id;
	private String value;
	
	public Bitcoin(){
		id=0;
	}
	public Bitcoin(int id, String value){
		this.id = id;
		this.value = value;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

}
