package com.bsuir.tritpo.fly.models.api_models;

import java.io.Serializable;

public class Place implements Serializable {
    private int PlaceId;
    private String IataCode;
    private String name;
    private String Type;
    private String SkyscannerCode;
    private String CityName;
    private String CityId;
    private String CountryName;

    public Place() {
    }

    public int getPlaceId() {
        return PlaceId;
    }

    public void setPlaceId(int placeId) {
        PlaceId = placeId;
    }

    public String getIataCode() {
        return IataCode;
    }

    public void setIataCode(String iataCode) {
        IataCode = iataCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getSkyscannerCode() {
        return SkyscannerCode;
    }

    public void setSkyscannerCode(String skyscannerCode) {
        SkyscannerCode = skyscannerCode;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getCityId() {
        return CityId;
    }

    public void setCityId(String cityId) {
        CityId = cityId;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }
}
