package com.smartweather.server.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;


import com.smartweather.server.model.WeatherLocation;

public interface WeatherRepository extends CrudRepository<WeatherLocation, String> {

	public List<WeatherLocation> findByNameContainingIgnoreCaseOrderByModifiedDateDesc(String locationName);
	 
	

}
