package com.bsuir.tritpo.fly.models.api_models;

import java.io.Serializable;
import java.util.List;

public class  FlightResponse implements Serializable {
    private FlightDate Dates;
    private List<Quote> Quotes;
    private List<Place> Places;
    private List<Carrier> Carriers;

    public FlightResponse() {
    }

    public FlightDate getDates() {
        return Dates;
    }

    public void setDates(FlightDate dates) {
        Dates = dates;
    }

    public List<Quote> getQuotes() {
        return Quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        Quotes = quotes;
    }

    public List<Place> getPlaces() {
        return Places;
    }

    public void setPlaces(List<Place> places) {
        Places = places;
    }

    public List<Carrier> getCarriers() {
        return Carriers;
    }

    public void setCarriers(List<Carrier> carriers) {
        Carriers = carriers;
    }
}
