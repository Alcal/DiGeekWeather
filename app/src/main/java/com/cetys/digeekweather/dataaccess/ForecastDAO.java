package com.cetys.digeekweather.dataaccess;

import android.util.Log;

import com.cetys.digeekweather.com.cetys.digeekweather.model.CurrentWeather;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Currency;

/**
 * Created by alejandrocastrolopez on 9/9/15.
 */
public class ForecastDAO {
    final String URL = "http://api.openweathermap.org/data/2.5/weather?q=Ensenada&APPID=7800b63f54b67a741706494f4b8c1ed3";

    public CurrentWeather getCurrentWeather (String city)
    {
        ResponseEntity<CurrentWeather> weather;
        try
        {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Log.i("ALEX", "attempting to weather!");
            weather = restTemplate.getForEntity(URL, CurrentWeather.class);
            Log.i("ALEX", "got weather!");
            return weather.getBody();
        }
        catch (Exception e)
        {
            Log.e("ALEX", e.getMessage());
        }

        return null;
    }

    /*
    public Alumno getAlumno(String matricula) {
        ResponseEntity<Alumno> alumno;
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Log.i("REST", "attempting alumno GET");
            String res = app.getString(R.string.alumno);
            alumno = restTemplate.getForEntity(URL+res+matricula, Alumno.class);
            Log.i("REST","alumno GET succesful");
            return alumno.getBody();
        } catch (Exception e) {
            Log.e("Home", e.getMessage(), e);
        }

        return null;
    }
    */
}
