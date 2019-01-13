package com.smartwheather.server.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartwheather.server.model.ApiResponse;

@Service
public class JsonHandlerService {
	@Autowired
	ObjectMapper mapper;

	public String ObjectToJson(Object obj) {

		String response = null;

		try {

			response = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

	public ApiResponse jsonToObject(String json, ApiResponse apiResponse) {

		try {
			apiResponse = mapper.readValue(json, ApiResponse.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return apiResponse;
	}

}
