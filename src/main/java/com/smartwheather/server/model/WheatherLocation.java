package com.smartwheather.server.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class WheatherLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String tokenLocation; /*
									 * Created from the latitude and longitude concatenation its a way to group all
									 * data under the same coordinate
									 */
	private String name;
	private String region;
	private String country;
	private Float lat;
	private Float lon;
	private String localtime;

	private long modifiedDate;

	@OneToMany(cascade = CascadeType.ALL)
	private List<WheatherData> wheatherDataList = new ArrayList<WheatherData>();

	public WheatherLocation() {

		this.setModifiedDate((new Date()).getTime());

	}

	public WheatherLocation(Location location) {

		super();

		this.setTokenLocation(location.getLat(), location.getLon());
		this.name = location.getName();
		this.region = location.getRegion();
		this.country = location.getCountry();
		this.lat = location.getLat();
		this.lon = location.getLon();
		this.localtime = location.getLocaltime();
		this.setModifiedDate((new Date()).getTime());

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

	public void addData(WheatherData data) {
		this.wheatherDataList.add(data);
	}

	public void setWheatherDataList(List<WheatherData> wheatherDataList) {
		this.wheatherDataList = wheatherDataList;
	}
	
	public List<WheatherData> getWheatherDataList() {
		return this.wheatherDataList;
	}

	public long getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(long modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
