package com.cetys.digeekweather.com.cetys.digeekweather.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by alejandrocastrolopez on 9/9/15.
 */

@JsonIgnoreProperties
public class Rain {
    @JsonProperty("3h")
    private float h3;

    public float getH3() {
        return h3;
    }

    public void setH3(float h3) {
        this.h3 = h3;
    }
}
