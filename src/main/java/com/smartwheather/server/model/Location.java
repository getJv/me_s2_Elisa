package com.smartwheather.server.model;

public class Location {

	private String name;
	private String region;
	private String country;
	private Float lat;
	private Float lon;
	private String localtime;

	public Location() {
	}

	public Location(String name, String region, String country, Float lat, Float lon, String localtime) {
		super();
		this.name = name;
		this.region = region;
		this.country = country;
		this.lat = lat;
		this.lon = lon;
		this.localtime = localtime;
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

}
