package com.cetys.digeekweather.com.cetys.digeekweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alejandrocastrolopez on 9/9/15.
 */
@JsonIgnoreProperties
public class City {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("coord")
    private Coord coord;
}
