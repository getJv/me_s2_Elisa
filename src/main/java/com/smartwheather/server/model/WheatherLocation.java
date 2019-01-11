package com.smartwheather.server.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class WheatherLocation {

	@Id
	private String id; /* Created from the latitude and longitude concatenation its a way to group all data under the same coordinate */ 
	private String name;
	private String region;
	private String country;
	private Float lat;
	private Float lon;
	private String localtime;
	@OneToMany(
			mappedBy = "wheatherLocation",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<WheatherData> wheatherData;

	public WheatherLocation() {
		
	}
	
	

	public WheatherLocation(String name, String region, String country, Float lat, Float lon,
			String localtime) {
		super();
		this.setId(lat, lon);
		this.name = name;
		this.region = region;
		this.country = country;
		this.lat = lat;
		this.lon = lon;
		this.localtime = localtime;
	}



	public String getId() {
		return String.valueOf(lat)+String.valueOf(lon);
	}
	
	private void setId(Float lat, Float lon) {
		this.id = String.valueOf(lat)+String.valueOf(lon);
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
