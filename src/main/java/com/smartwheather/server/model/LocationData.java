package com.smartwheather.server.model;

import java.util.List;

public class LocationData {

	private Long id;
	private Float lat;
	private Float lon;
	private String city;
	
	private String last_update;
	private Float temp_c;
	private Float precip_mm;
	
	private String condition;
	private String icon_url;
	
	private List<ForecastData> forecastDays;
	
	
	
	public LocationData() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
