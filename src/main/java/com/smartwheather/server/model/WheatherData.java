package com.smartwheather.server.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class WheatherData {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wheatherLocation_id")
	private WheatherLocation wheatherLocation;
	private String jsonData;
	
	public WheatherData() {
		// TODO Auto-generated constructor stub
	}

}
