package com.bsuir.tritpo.fly.singletons;


import com.bsuir.tritpo.fly.models.api_models.airport_model.Airport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("singleton")
public class AirportsSingleton {
    private List<Airport> airportList;

    public List<Airport> getAirportList() {
        return airportList;
    }

    public void setAirportList(List<Airport> airportList) {
        this.airportList = airportList;
    }
}
