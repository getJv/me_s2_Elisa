package com.smartwheather.server.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApixuService {

	private final String root_uri = "http://api.apixu.com/v1/forecast.json?key=56f115b2469844ebad0232253190901";

	public String getWheatherData(String queryText, Integer numberOfDays) {

		RestTemplate restTemplate = new RestTemplate();

		String uri = this.root_uri + "&q=" + queryText + "&days=" + numberOfDays;

		return restTemplate.getForObject(uri, String.class);

	}

}
