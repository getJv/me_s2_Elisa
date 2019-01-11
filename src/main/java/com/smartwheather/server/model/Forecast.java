package com.smartwheather.server.model;






import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast  {

	public List<Forecastday> farecastday;

	public Forecast() {
		// TODO Auto-generated constructor stub
		
	}
	

	public Forecast(List<Forecastday> farecastday) {
		super();
		this.farecastday = farecastday;
		
	}
	
	


	public List<Forecastday> getFarecastday() {
		return farecastday;
	}

	public void setFarecastday(List<Forecastday> farecastday) {
		this.farecastday = farecastday;
	}

	

}
