package com.bsuir.tritpo.fly.services.impl;

import com.bsuir.tritpo.fly.REST.RESTConstants;
import com.bsuir.tritpo.fly.REST.RESTMethods;
import com.bsuir.tritpo.fly.models.api_models.FlightResponse;
import com.bsuir.tritpo.fly.services.FlightService;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {


    @Override
    public FlightResponse getAvailableFlights(String originPlace, String destinationPlace,
                                              String outboundPartialDate) throws UnirestException {
        HttpResponse<String> response = Unirest.get(RESTMethods.GET_FLIGHTS + RESTConstants.COUNTRY + '/' +
                RESTConstants.CURRENCY + '/' + RESTConstants.LOCALE + '/' +
                originPlace + '/' + destinationPlace + '/' + outboundPartialDate)
                .header(RESTConstants.RapidAPI_HOST_KEY, RESTConstants.RapidAPI_HOST_VALUE)
                .header(RESTConstants.RapidAPI_TOKEN_KEY, RESTConstants.RapidAPI_TOKEN_VALUE)
                .asObject(String.class);
        Gson g = new Gson();
        return g.fromJson(response.getBody(), FlightResponse.class);
    }
}
