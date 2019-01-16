package com.smartweather.server.controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import com.smartweather.server.exceptions.LocalDataExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.smartweather.server.exceptions.NoLocalDataFoundException;
import com.smartweather.server.model.ApiResponse;
import com.smartweather.server.model.WeatherData;
import com.smartweather.server.model.WeatherLocation;
import com.smartweather.server.service.ApixuService;
import com.smartweather.server.service.JsonHandlerService;
import com.smartweather.server.service.WeatherService;
@CrossOrigin(maxAge = 3600)
@RestController
public class WeatherController {

	@Autowired
	private ApixuService weatherApiService;

	@Autowired
	JsonHandlerService jsonHandler;

	@Autowired
	WeatherService weatherService;

	@GetMapping("/")
	public String index() {

		return "index";
	}

	private List<WeatherLocation> getLocalData(String location) throws NoLocalDataFoundException {
		List<WeatherLocation> localSearch = weatherService.find(location);
		if (localSearch.isEmpty())
			throw new NoLocalDataFoundException();
		return localSearch;
	}

	private void storeNewData(String json) {

		ApiResponse obj = new ApiResponse();
		obj = jsonHandler.jsonToObject(json, obj);
		WeatherLocation weatherLocation = new WeatherLocation(obj.getLocation());
		weatherLocation.addData(new WeatherData(json));
		weatherService.save(weatherLocation);

	}

	private void isMoreThenOneHourOld(WeatherLocation wl) throws LocalDataExpiredException {

		Long timeLife = Duration.between(wl.getModifiedDate(), LocalDateTime.now()).toMinutes();
		if (timeLife > 0)
			throw new LocalDataExpiredException();
	}

	@GetMapping("/weather/{location}")
	public String weather(@PathVariable String location) {

		String json = null;
		List<WeatherLocation> localSearch = null;
		try {
			localSearch = this.getLocalData(location);
			this.isMoreThenOneHourOld(localSearch.get(0));
			int mostUpdatedInfo = localSearch.get(0).getWeatherDataList().size() - 1;
			json = localSearch.get(0).getWeatherDataList().get(mostUpdatedInfo).getJsonData();

		} catch (LocalDataExpiredException e) {

			json = weatherApiService.getWeatherData(location);

			localSearch.get(0).addData(new WeatherData(json));
			localSearch.get(0).setUpdatedOn();
			weatherService.save(localSearch.get(0));

		} catch (NoLocalDataFoundException e) {

			json = weatherApiService.getWeatherData(location);

			this.storeNewData(json);
		}
		return json;

	}

}
