package com.cetys.digeekweather.com.cetys.digeekweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alejandrocastrolopez on 9/9/15.
 */
@JsonIgnoreProperties
public class Sys {

    @JsonProperty("type")
    private int type;

    @JsonProperty("id")
    private int id;

    @JsonProperty("message")
    private float message;

    @JsonProperty("country")
    private String country;

    @JsonProperty("sunrise")
    private int sunrise;

    @JsonProperty("sunset")
    private int sunset;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMessage() {
        return message;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSunrise() {
        return sunrise;
    }

    public void setSunrise(int sunrise) {
        this.sunrise = sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public void setSunset(int sunset) {
        this.sunset = sunset;
    }
}

/*
* "sys":
        {
        "type":3,
        "id":7607,
        "message":0.0045,
        "country":"JP",
        "sunrise":1441830184,
        "sunset":1441875556
        },
* */