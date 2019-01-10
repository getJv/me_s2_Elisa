package com.smartwheather.server.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents the contition of wheather and the icon_uri
 * @author Jhonatan Morais
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Condition {
	
	private String text;
	private String icon; /*TODO Jhonatan: stores all icons to us. */
	
	public Condition() {}
	
	public Condition(String text, String icon) {
		super();
		this.text = text;
		this.icon = icon;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

}
