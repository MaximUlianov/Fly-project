package com.bsuir.tritpo.fly.services;

import com.bsuir.tritpo.fly.models.api_models.FlightResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface FlightService {
    FlightResponse getAvailableFlights(String originPlace, String destinationPlace,
                                       String outboundPartialDate) throws UnirestException;
}
