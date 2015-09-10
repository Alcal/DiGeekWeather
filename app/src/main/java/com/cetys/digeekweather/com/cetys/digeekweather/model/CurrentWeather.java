package com.cetys.digeekweather.com.cetys.digeekweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alejandrocastrolopez on 9/9/15.
 */
@JsonIgnoreProperties
public class CurrentWeather {

    @JsonProperty("coord")
    private Coord coord;

    @JsonProperty("weather")
    private Weather[] weather;

    @JsonProperty("base")
    private String base;

    @JsonProperty("main")
    private MainW mainW;

    @JsonProperty("wind")
    private Wind wind;

    @JsonProperty("rain")
    private Rain rain;

    @JsonProperty("clouds")
    private Clouds clouds;

    @JsonProperty("dt")
    private int dt;

    @JsonProperty("sys")
    private Sys sys;

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("cod")
    private int cod;


        public Coord getCoord() {
                return coord;
        }

        public void setCoord(Coord coord) {
                this.coord = coord;
        }

        public Weather[] getWeather() {
                return weather;
        }

        public void setWeather(Weather[] weather) {
                this.weather = weather;
        }

        public String getBase() {
                return base;
        }

        public void setBase(String base) {
                this.base = base;
        }

        public MainW getMainW() {
                return mainW;
        }

        public void setMainW(MainW mainW) {
                this.mainW = mainW;
        }

        public Wind getWind() {
                return wind;
        }

        public void setWind(Wind wind) {
                this.wind = wind;
        }

        public Rain getRain() {
                return rain;
        }

        public void setRain(Rain rain) {
                this.rain = rain;
        }

        public Clouds getClouds() {
                return clouds;
        }

        public void setClouds(Clouds clouds) {
                this.clouds = clouds;
        }

        public int getDt() {
                return dt;
        }

        public void setDt(int dt) {
                this.dt = dt;
        }

        public Sys getSys() {
                return sys;
        }

        public void setSys(Sys sys) {
                this.sys = sys;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getCod() {
                return cod;
        }

        public void setCod(int cod) {
                this.cod = cod;
        }
}