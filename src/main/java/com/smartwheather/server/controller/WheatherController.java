package com.smartwheather.server.controller;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(maxAge = 3600)
@RestController
public class WheatherController {

	@Autowired
	private ApixuService wheatherApiService;

	@Autowired
	JsonHandlerService jsonHandler;

	@Autowired
	WheatherService wheatherService;

	@GetMapping("/")
	public String index() {

		return "index";
	}

	private List<WheatherLocation> getLocalData(String location) throws NoLocalDataFoundException {
		List<WheatherLocation> localSearch = wheatherService.find(location);
		if (localSearch.isEmpty())
			throw new NoLocalDataFoundException();
		return localSearch;
	}

	private void storeNewData(String json) {

		ApiResponse obj = new ApiResponse();
		obj = jsonHandler.jsonToObject(json, obj);
		WheatherLocation wheatherLocation = new WheatherLocation(obj.getLocation());
		wheatherLocation.addData(new WheatherData(json));
		wheatherService.save(wheatherLocation);

	}

	private void isMoreThenOneHourOld(WheatherLocation wl) throws LocalDataExpiredException {

		Long timeLife = Duration.between(wl.getModifiedDate(), LocalDateTime.now()).toMinutes();
		if (timeLife > 0)
			throw new LocalDataExpiredException();
	}

	@GetMapping("/wheather/{location}")
	public String wheather(@PathVariable String location) {

		String json = null;
		List<WheatherLocation> localSearch = null;
		try {
			localSearch = this.getLocalData(location);
			this.isMoreThenOneHourOld(localSearch.get(0));
			int mostUpdatedInfo = localSearch.get(0).getWheatherDataList().size() - 1;
			json = localSearch.get(0).getWheatherDataList().get(mostUpdatedInfo).getJsonData();

		} catch (LocalDataExpiredException e) {

			json = wheatherApiService.getWheatherData(location);

			localSearch.get(0).addData(new WheatherData(json));
			localSearch.get(0).setUpdatedOn();
			wheatherService.save(localSearch.get(0));

		} catch (NoLocalDataFoundException e) {

			json = wheatherApiService.getWheatherData(location);

			this.storeNewData(json);
		}
		return json;

	}

}
