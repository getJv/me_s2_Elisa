package com.smartwheather.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartwheather.server.model.WheatherLocation;
import com.smartwheather.server.repository.WheatherRepository;

@Service
public class WheatherService {

	@Autowired
	private WheatherRepository repo;

	public WheatherService() {
		// TODO Auto-generated constructor stub
	}

	public void save(WheatherLocation data) {

		repo.save(data);
	}

	public List<WheatherLocation> find(String stringSearch) {

		return repo.findByNameContainingIgnoreCaseOrderByModifiedDateDesc(stringSearch);
	}

}
