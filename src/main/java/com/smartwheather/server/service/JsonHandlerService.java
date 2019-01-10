package com.smartwheather.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JsonHandlerService {
	@Autowired
	ObjectMapper mapper;
	
	public String ObjectToJson(Object obj) {
		
		
		String response = null;

		try {

			response = mapper.writeValueAsString( obj );
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}
	

}
