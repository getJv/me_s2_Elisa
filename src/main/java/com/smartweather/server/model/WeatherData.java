package com.smartweather.server.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime modifiedDate;

    @Type(type = "text")
    private String jsonData;

    public WeatherData() {

    }

    public WeatherData(String data) {

        this.jsonData = data;
        this.setUpdatedOn();
    }

    public void setUpdatedOn() {
        this.setModifiedDate(LocalDateTime.now());

    }


    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

}
