package com.smartweather.server.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiResponse {

    private Location location;
    private Current current;
    private Forecast forecast;

}
