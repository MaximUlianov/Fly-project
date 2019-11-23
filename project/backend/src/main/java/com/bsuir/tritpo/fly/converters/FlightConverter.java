package com.bsuir.tritpo.fly.converters;

import com.bsuir.tritpo.fly.models.api_models.airport_model.Airport;

import java.util.List;

public interface FlightConverter {
    List<Airport> filterAirports(Airport[] airports);
}
