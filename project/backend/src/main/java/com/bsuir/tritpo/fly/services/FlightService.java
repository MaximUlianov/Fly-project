package com.bsuir.tritpo.fly.services;

import com.bsuir.tritpo.fly.models.api_models.FlightResponse;
import com.bsuir.tritpo.fly.models.api_models.airport_model.Airport;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

public interface FlightService {
    FlightResponse getAvailableFlights(String originPlace, String destinationPlace,
                                       String outboundPartialDate) throws UnirestException;
    List<Airport> getAirports() throws UnirestException;
}
