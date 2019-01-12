package com.smartwheather.server.model;





import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecastday  {

	private String date; /**TODO handle like data type*/
	private Day day;
	
	public Forecastday() {
		// TODO Auto-generated constructor stub
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	  public Day getDay() { return day; }
	  
	  public void setDay(Day day) { this.day = day; }
	 
	

}
