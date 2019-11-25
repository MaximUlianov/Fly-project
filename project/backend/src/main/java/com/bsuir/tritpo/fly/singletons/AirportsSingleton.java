package com.bsuir.tritpo.fly.singletons;


import com.bsuir.tritpo.fly.models.DTOs.AirportSuggestionDto;
import com.bsuir.tritpo.fly.models.api_models.airport_model.Airport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("singleton")
public class AirportsSingleton {
    private List<Airport> airportList;
     private List<AirportSuggestionDto> airportSuggetstions;

    public List<Airport> getAirportList() {
        return airportList;
    }

    public void setAirportList(List<Airport> airportList) {
        this.airportList = airportList;
    }

    public List<AirportSuggestionDto> getAirportSuggetstions() {
        return airportSuggetstions;
    }

    public void setAirportSuggetstions(List<AirportSuggestionDto> airportSuggetstions) {
        this.airportSuggetstions = airportSuggetstions;
    }
}
