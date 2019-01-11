package com.smartwheather.server.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartwheather.server.model.ApiResponse;


/**
 * Get Wheather data from Apixu API
 * 
 * @author Jhonatan Morais
 */
@Service
public class ApixuService {

	private final String root_uri = "http://api.apixu.com/v1/forecast.json?key=56f115b2469844ebad0232253190901";;
	
	/**
	 * Get forecast data of one location and the preview for next 10 days (max) 
	 * 
	 * @param queryText can be one of this values: Pass US Zipcode, UK Postcode, Canada Postalcode, IP address, Latitude/Longitude (decimal degree) or city name
	 * @param numberOfDays beween 1 and 10 (max) 
	 * @return a json as String
	 */
	public ApiResponse getWheatherData(String queryText, Integer numberOfDays) {

		String uri = this.root_uri + "&q="+ queryText + "&days=" + numberOfDays;
		System.out.println(uri);
				
		RestTemplate restTemplate = new RestTemplate();
		ApiResponse apiResponse = restTemplate.getForObject(uri, ApiResponse.class);
		
		return apiResponse;

	}
	/**
	 * Get forecast data of one location to actual moment
	 * 
	 * @param queryText can be one of this values: Pass US Zipcode, UK Postcode, Canada Postalcode, IP address, Latitude/Longitude (decimal degree) or city name
	 * @return a json as String
	 */
	public String getWheatherData(String queryText) {

		String uri = this.root_uri + "&q="+ queryText;
		
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);

		return result;

	}

}
