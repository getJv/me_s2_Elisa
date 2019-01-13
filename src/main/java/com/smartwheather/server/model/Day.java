package com.smartwheather.server.model;

public class Day {

	private Float avgtemp_c;
	private Float totalprecip_mm;
	private Condition condition;

	public Day() {
		// TODO Auto-generated constructor stub

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

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

}
