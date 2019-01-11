package com.smartwheather.server.model;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartwheather.server.service.JsonHandlerService;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
	
	private Location location;
	private Current current; 
	private Forecast forecast;
	
	
	public Current getCurrent() {
		return current;
	}

	public void setCurrent(Current current) {
		this.current = current;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Forecast getForecast() {
		return forecast;
	}

	public void setForecast(Forecast forecast) {
		this.forecast = forecast;
	}
	
	/* Test to recovery the forecast attr */ 

	/*
	 * @SuppressWarnings("unchecked")
	 * 
	 * @JsonProperty("forecast") private void unpackNested(Map<String,Object>
	 * forecast) throws ClassNotFoundException, IOException {
	 * System.out.println(forecast.get("forecastday")); ObjectMapper mapper = new
	 * ObjectMapper(); String tt =
	 * "[{\"date\":\"2019-01-11\"},{\"date\":\"2019-01-11\"}]"; List<Forecastday>
	 * myObjects = Arrays.asList(mapper.readValue(tt, Forecastday[].class));
	 * 
	 * System.out.println(myObjects);
	 * 
	 * //System.out.println(jsHandler.parseJsonArray(forecast.get("forecastday").
	 * toString(), Forecastday.class));
	 * 
	 * //
	 * 
	 * //this.brandName = (String)brand.get("name"); //Map<String,String> owner =
	 * (Map<String,String>)brand.get("owner"); //this.ownerName = owner.get("name");
	 * }
	 */
	

}
