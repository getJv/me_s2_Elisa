package com.smartwheather.server.model;

public class Current {

	private String last_updated; /* TODO Jhonatan: handle to work with data types */
	private Float temp_c;
	private Float precip_mm;
	private Condition condition;

	public Current() {
	}

	public Current(String last_updated, Float temp_c, Float precip_mm, Condition condition) {
		super();
		this.last_updated = last_updated;
		this.temp_c = temp_c;
		this.precip_mm = precip_mm;
		this.condition = condition;
	}

	public String getLast_updated() {
		return last_updated;
	}

	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}

	public Float getTemp_c() {
		return temp_c;
	}

	public void setTemp_c(Float temp_c) {
		this.temp_c = temp_c;
	}

	public Float getPrecip_mm() {
		return precip_mm;
	}

	public void setPrecip_mm(Float precip_mm) {
		this.precip_mm = precip_mm;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

}
