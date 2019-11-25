package com.bsuir.tritpo.fly.controllers;


import com.bsuir.tritpo.fly.converters.FlightConverter;
import com.bsuir.tritpo.fly.models.DTOs.AirportSuggestionDto;
import com.bsuir.tritpo.fly.models.DTOs.FlightDTO;
import com.bsuir.tritpo.fly.services.FlightService;
import com.bsuir.tritpo.fly.singletons.AirportsSingleton;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    private FlightService flightService;

    private FlightConverter flightConverter;

    private AirportsSingleton airportsSingleton;

    @Autowired
    public FlightController(FlightService flightService, FlightConverter flightConverter,
                            AirportsSingleton airportsSingleton) {
        this.flightService = flightService;
        this.flightConverter = flightConverter;
        this.airportsSingleton = airportsSingleton;
    }

    @GetMapping(value = "/getAvailableFlights/{originPlace}/{destinationPlace}/{outboundPartialDate}")
    @ResponseBody
    public ResponseEntity getFlight(@PathVariable("originPlace") String originPlace,
                                    @PathVariable("destinationPlace") String destinationPlace,
                                    @PathVariable("outboundPartialDate") String outboundPartialDate) {
        FlightDTO response = null;
        try {
            response = flightService.getAvailableFlights(originPlace, destinationPlace, outboundPartialDate);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.ok("ok");
    }

    @GetMapping(value = "/getAirports/{searchValue}")
    @ResponseBody
    public ResponseEntity getAirports(@PathVariable("searchValue") String searchValue) {
        List<AirportSuggestionDto> airports = airportsSingleton.getAirportSuggetstions();
        if (airports != null){
            return ResponseEntity.ok(flightConverter.findAirportsByCityName(airports, searchValue));
        }
        return ResponseEntity.ok("ok");
    }
}