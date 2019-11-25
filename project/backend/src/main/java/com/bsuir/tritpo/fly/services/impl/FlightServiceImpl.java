package com.bsuir.tritpo.fly.services.impl;

import com.bsuir.tritpo.fly.REST.RESTConstants;
import com.bsuir.tritpo.fly.REST.RESTMethods;
import com.bsuir.tritpo.fly.converters.FlightConverter;
import com.bsuir.tritpo.fly.models.DTOs.AirportSuggestionDto;
import com.bsuir.tritpo.fly.models.DTOs.FlightDTO;
import com.bsuir.tritpo.fly.models.api_models.FlightResponse;
import com.bsuir.tritpo.fly.models.api_models.airport_model.Airport;
import com.bsuir.tritpo.fly.services.FlightService;
import com.bsuir.tritpo.fly.singletons.AirportsSingleton;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private FlightConverter flightConverter;

    @Autowired
    private AirportsSingleton airportsSingleton;

    @Autowired
    public FlightServiceImpl(FlightConverter flightConverter) {
        this.flightConverter = flightConverter;
    }


    @Override
    public FlightDTO getAvailableFlights(String originPlace, String destinationPlace,
                                         String outboundPartialDate) throws UnirestException {
        originPlace += RESTConstants.PLACE_POSTFIX;
        destinationPlace += RESTConstants.PLACE_POSTFIX;
        HttpResponse<String> response = Unirest.get(RESTMethods.GET_FLIGHTS + RESTConstants.COUNTRY + '/' +
                RESTConstants.CURRENCY + '/' + RESTConstants.LOCALE + '/' +
                originPlace + '/' + destinationPlace + '/' + outboundPartialDate)
                .header(RESTConstants.RapidAPI_HOST_KEY, RESTConstants.RapidAPI_HOST_VALUE)
                .header(RESTConstants.RapidAPI_TOKEN_KEY, RESTConstants.RapidAPI_TOKEN_VALUE)
                .asObject(String.class);
        Gson g = new Gson();
        FlightResponse flightResponse = g.fromJson(response.getBody(), FlightResponse.class);
        if (flightResponse != null) {
            return flightConverter.convertFlightResponseToDTO(flightResponse);
        }
        return null;
    }

    @PostConstruct
    @Override
    public List<Airport> getAirports() throws UnirestException {
        HttpResponse<String> response = Unirest.get(RESTMethods.GET_AIRPORTS)
                .header(RESTConstants.AIRPORTS_ACCESS_KEY, RESTConstants.AIRPORTS_ACCESS_VALUE)
                .asObject(String.class);
        Gson g = new Gson();
        List<Airport> airports = flightConverter.filterAirports(g.fromJson(response.getBody(), Airport[].class));
        List<AirportSuggestionDto> airportSuggestions = flightConverter.convertAirportsToSuggestion(airports);
        airportsSingleton.setAirportList(airports);
        airportsSingleton.setAirportSuggetstions(airportSuggestions);
        return airports;
    }

}
