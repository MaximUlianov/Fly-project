package com.bsuir.tritpo.fly.converters.impl;

import com.bsuir.tritpo.fly.converters.FlightConverter;
import com.bsuir.tritpo.fly.models.DTOs.AirportSuggestionDto;
import com.bsuir.tritpo.fly.models.api_models.airport_model.Airport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<AirportSuggestionDto> convertAirportsToSuggestion(List<Airport> airports) {
        List<AirportSuggestionDto> airportSuggestions = new ArrayList<>();
        airports.forEach(airport -> {
            AirportSuggestionDto airportSuggestion = new AirportSuggestionDto();
            String[] sep = airport.getTime_zone().split("\\/");
            airportSuggestion.setName(sep[1]);
            airportSuggestion.setCode(airport.getCode());
            airportSuggestions.add(airportSuggestion);
        });
        return airportSuggestions;
    }

    @Override
    public List<AirportSuggestionDto> findAirportsByCityName(List<AirportSuggestionDto> airportSuggestions, String searchValue) {
        return airportSuggestions
                .stream()
                .filter(suggestion -> suggestion.getName().contains(searchValue))
                .collect(Collectors.toList());
    }
}
