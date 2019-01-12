package com.smartwheather.server.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.smartwheather.server.model.ApiResponse;
import com.smartwheather.server.model.WheatherData;
import com.smartwheather.server.model.WheatherLocation;
import com.smartwheather.server.service.ApixuService;
import com.smartwheather.server.service.JsonHandlerService;
import com.smartwheather.server.service.WheatherService;

@RestController
public class WheatherController {

	@Autowired
	private ApixuService wheatherApiService;

	@Autowired
	JsonHandlerService JsonHandler;

	@Autowired
	WheatherService wheatherService;
	
	@GetMapping("/")
	public String index() {

		return "index";
	}

	@GetMapping("/wheather/{location}/days/{days}")
	public String wheather(@PathVariable String location, @PathVariable Integer days) {
		
		//Check if we have  the no expired data
		// if yes, return it
		// if no, get them from Api service, store it and then return it.
		
		ApiResponse obj = wheatherApiService.getWheatherData(location, days);
		
		String json = JsonHandler.ObjectToJson(obj);
		
		//WheatherLocation wheatherLocation = new WheatherLocation(obj.getLocation());
			
		//wheatherLocation.addData(new WheatherData(json));
		
		//wheatherService.save(wheatherLocation);
		
		
		
		
		
		
		
		return json;

	}
	
	/*TODO Jhonatan 
	 * Store the data, direct in controlle or using a middleware.
	 * Other method (to check the past days)
	 */

}
