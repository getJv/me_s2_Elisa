package com.smartwheather.server.repository;

import org.springframework.data.repository.CrudRepository;

import com.smartwheather.server.model.WheatherLocation;

public interface WheatherRepository extends CrudRepository<WheatherLocation, String> {

}
