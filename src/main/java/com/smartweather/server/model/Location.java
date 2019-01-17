package com.smartweather.server.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Location {

    private String name;
    private String region;
    private String country;
    private Float lat;
    private Float lon;
    private String localtime;


}
