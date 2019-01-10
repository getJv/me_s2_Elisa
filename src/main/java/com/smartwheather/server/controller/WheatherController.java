package com.smartwheather.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.smartwheather.server.service.ApixuService;
import com.smartwheather.server.service.JsonHandlerService;

@RestController
public class WheatherController {

	@Autowired
	private ApixuService wheatherService;

	@Autowired
	JsonHandlerService JsonHandler;

	@GetMapping("/")
	public String index() {

		return "index";
	}

	@GetMapping("/wheather/{location}/days/{days}")
	public String wheather(@PathVariable String location, @PathVariable Integer days) {

		return JsonHandler.ObjectToJson(wheatherService.getWheatherData(location, days));

	}
	
	/*TODO Jhonatan 
	 * Store the data, direct in controlle or using a middleware.
	 * Other method (to check the past days)
	 */

}
