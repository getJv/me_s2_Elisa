package com.smartwheather.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.smartwheather.server.ApixuService;

@RestController
public class WheatherController {

	
	@Autowired
	private ApixuService  wheatherService;
	
	@GetMapping("/")
    public String index(){
		
		
		wheatherService.getWheatherData("paris",7);
	
        return wheatherService.getWheatherData("paris",7);
    }
	

}
