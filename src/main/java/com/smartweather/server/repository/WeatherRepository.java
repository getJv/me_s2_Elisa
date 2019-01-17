package com.smartweather.server.repository;

import com.smartweather.server.model.WeatherLocation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeatherRepository extends CrudRepository<WeatherLocation, String> {

    List<WeatherLocation> findByNameContainingIgnoreCaseOrderByModifiedDateDesc(String locationName);


}
