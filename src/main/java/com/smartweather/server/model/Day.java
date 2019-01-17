package com.smartweather.server.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Day {

    private Float avgtemp_c;
    private Float totalprecip_mm;
    private Condition condition;

}
