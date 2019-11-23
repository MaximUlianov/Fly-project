package com.bsuir.tritpo.fly.converters.impl;

import com.bsuir.tritpo.fly.converters.FlightConverter;
import com.bsuir.tritpo.fly.models.api_models.airport_model.Airport;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightConverterImpl implements FlightConverter {
    @Override
    public List<Airport> filterAirports(Airport[] airports) {
        List<Airport> airportList = Arrays.asList(airports);
        return airportList.stream().filter(Airport::isFlightable).collect(Collectors.toList());
    }
}
