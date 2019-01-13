package com.smartwheather.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.smartwheather.server.exceptions.LocalDataExpiredException;
import com.smartwheather.server.exceptions.NoLocalDataFoundException;
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

		String json = null;
		try {
			List<WheatherLocation> localSearch = wheatherService.find(location);
			if (localSearch.isEmpty())
				throw new NoLocalDataFoundException();
			json = localSearch.get(0).getWheatherDataList().get(0).getJsonData();
			System.out.println("from local storage");
			// TODO }catch (LocalDataExpiredException e) { 
		} catch (NoLocalDataFoundException e) {

			json = wheatherApiService.getWheatherData(location, days);
			ApiResponse obj = new ApiResponse();
			obj = JsonHandler.jsonToObject(json, obj);
			WheatherLocation wheatherLocation = new WheatherLocation(obj.getLocation());
			wheatherLocation.addData(new WheatherData(json));
			wheatherService.save(wheatherLocation);
			System.out.println("from remote api");
		}
		return json;

	}

}
