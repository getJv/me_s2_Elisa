package com.smartweather.server.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Forecast {

    public List<Forecastday> forecastday;


}
