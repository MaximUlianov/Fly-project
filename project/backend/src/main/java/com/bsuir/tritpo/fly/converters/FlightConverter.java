package com.bsuir.tritpo.fly.converters;

import com.bsuir.tritpo.fly.models.DTOs.AirportSuggestionDto;
import com.bsuir.tritpo.fly.models.DTOs.FlightDTO;
import com.bsuir.tritpo.fly.models.api_models.FlightResponse;
import com.bsuir.tritpo.fly.models.api_models.airport_model.Airport;

import java.util.List;

public interface FlightConverter {
    List<Airport> filterAirports(Airport[] airports);
    List<AirportSuggestionDto> convertAirportsToSuggestion(List<Airport> airports);
    List<AirportSuggestionDto> findAirportsByCityName(List<AirportSuggestionDto> airportSuggestions,
                                                      String searchValue);
    FlightDTO convertFlightResponseToDTO(FlightResponse flightResponse, String origin,  String destination,
                                         String date);
}
