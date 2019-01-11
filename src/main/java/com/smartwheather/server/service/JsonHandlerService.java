package com.smartwheather.server.service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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

			response = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

	public <T> List<T> parseJsonArray(String json, Class<T> classOnWhichArrayIsDefined)
			throws IOException, ClassNotFoundException {
		ObjectMapper mapper = new ObjectMapper();
		@SuppressWarnings("unchecked")
		Class<T[]> arrayClass = (Class<T[]>) Class.forName("[L" + classOnWhichArrayIsDefined.getName() + ";");
		T[] objects = mapper.readValue(json, arrayClass);
		return Arrays.asList(objects);
	}

}
