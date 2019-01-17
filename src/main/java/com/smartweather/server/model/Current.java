package com.smartweather.server.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Current {

    private String last_updated;
    private Float temp_c;
    private Float precip_mm;
    private Condition condition;

}
