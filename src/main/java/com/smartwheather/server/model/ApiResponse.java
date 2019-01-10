package com.smartwheather.server.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
	
	private Location location;
	private Current current; 
	
	/*TODO Jhonatan
	 * Forecast attr.
	 * wheather attr	
	 */

	public Current getCurrent() {
		return current;
	}

	public void setCurrent(Current current) {
		this.current = current;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	
	
	

}
