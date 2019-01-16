package com.smartweather.server.service;

import java.util.List;

import com.smartweather.server.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartweather.server.model.WeatherLocation;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository repo;

	public WeatherService() {
		// TODO Auto-generated constructor stub
	}

	public void save(WeatherLocation data) {

		repo.save(data);
	}

	public List<WeatherLocation> find(String stringSearch) {

		return repo.findByNameContainingIgnoreCaseOrderByModifiedDateDesc(stringSearch);
	}
	
	

}
