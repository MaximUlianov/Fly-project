package com.bsuir.tritpo.fly.models.api_models.airport_model;

import java.io.Serializable;

public class Airport implements Serializable {
    private String time_zone;
    private String name;
    private boolean flightable;
    private String city_code;

    public Airport() {
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFlightable() {
        return flightable;
    }

    public void setFlightable(boolean flightable) {
        this.flightable = flightable;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }
}
