package com.smartwheather.server.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

@Entity
public class WheatherData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Type(type = "text")
	private String jsonData;

	public WheatherData() {
		// TODO Auto-generated constructor stub
	}

	public WheatherData(String rawData) {
		this.jsonData = rawData;
	}

	
}
