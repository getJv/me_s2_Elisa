package com.smartwheather.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WheatherController {

	//@Autowired
	//private WheatherService ws; 
	
	
	
	
	
	
	
	@GetMapping("/")
    public String index(){
		
		final String uri = "http://api.apixu.com/v1/forecast.json?key=56f115b2469844ebad0232253190901&q=paris&days=7";

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);

	    System.out.println(result);
		
		
		
		
        return "kkkkkk";
    }
	

}
