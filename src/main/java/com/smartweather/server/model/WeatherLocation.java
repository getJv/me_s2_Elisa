package com.smartweather.server.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class WeatherLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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

    public void addData(WeatherData data) {
        this.weatherDataList.add(data);
    }


}
