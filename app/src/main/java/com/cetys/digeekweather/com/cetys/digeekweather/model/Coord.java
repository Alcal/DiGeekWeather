package com.cetys.digeekweather.com.cetys.digeekweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alejandrocastrolopez on 9/9/15.
 */
@JsonIgnoreProperties
public class Coord {

    @JsonProperty("lat")
    private float lat;

    @JsonProperty("lon")
    private float lon;

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }
}
