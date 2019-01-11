package com.smartwheather.server.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Day {

	private Float  avgtemp_c;
	private Float totalprecip_mm;
	private List<Condition> condition;
	
	
	public Day() {
		// TODO Auto-generated constructor stub
		System.out.println("day constructor");
	}


	public Day(Float avgtemp_c, Float totalprecip_mm, List<Condition> condition) {
		super();
		this.avgtemp_c = avgtemp_c;
		this.totalprecip_mm = totalprecip_mm;
		this.condition = condition;
	}


	public Float getAvgtemp_c() {
		return avgtemp_c;
	}


	public void setAvgtemp_c(Float avgtemp_c) {
		this.avgtemp_c = avgtemp_c;
	}


	public Float getTotalprecip_mm() {
		return totalprecip_mm;
	}


	public void setTotalprecip_mm(Float totalprecip_mm) {
		this.totalprecip_mm = totalprecip_mm;
	}


	public List<Condition> getCondition() {
		return condition;
	}


	public void setCondition(List<Condition> condition) {
		this.condition = condition;
	}
	
	

}
