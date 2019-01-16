package com.smartweather.server.model;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class WeatherLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String tokenLocation;
	private String name;
	private String region;
	private String country;
	private Float lat;
	private Float lon;
	private String localtime;
	
	private LocalDateTime modifiedDate;

	@OneToMany(cascade = CascadeType.ALL)
	private List<WeatherData> weatherDataList = new ArrayList<WeatherData>();

	public WeatherLocation() {

		

	}

	public WeatherLocation(Location location) {

		super();

		this.setTokenLocation(location.getLat(), location.getLon());
		this.name = location.getName();
		this.region = location.getRegion();
		this.country = location.getCountry();
		this.lat = location.getLat();
		this.lon = location.getLon();
		this.localtime = location.getLocaltime();
		this.setUpdatedOn();

	}

	public void setUpdatedOn() {
		this.setModifiedDate(LocalDateTime.now());
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLon() {
		return lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}

	public String getLocaltime() {
		return localtime;
	}

	public void setLocaltime(String localtime) {
		this.localtime = localtime;
	}

	public String getTokenLocation() {
		return tokenLocation;
	}

	public void setTokenLocation(Float lat, Float lon) {
		this.tokenLocation = Float.toString(lat) + "," + Float.toString(lon);
	}

	public void addData(WeatherData data) {
		this.weatherDataList.add(data);
	}

	public void setWeatherDataList(List<WeatherData> weatherDataList) {
		this.weatherDataList = weatherDataList;
	}

	public List<WeatherData> getWeatherDataList() {
		return this.weatherDataList;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
