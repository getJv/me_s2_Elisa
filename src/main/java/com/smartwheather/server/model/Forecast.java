package com.smartwheather.server.model;

import java.util.List;

public class Forecast {

	public List<Forecastday> forecastday;

	public Forecast() {
		// TODO Auto-generated constructor stub

	}

	public Forecast(List<Forecastday> forecastday) {
		super();
		this.forecastday = forecastday;

	}

	public List<Forecastday> getForecastday() {
		return forecastday;
	}

	public void setForecastday(List<Forecastday> forecastday) {
		this.forecastday = forecastday;
	}

}
