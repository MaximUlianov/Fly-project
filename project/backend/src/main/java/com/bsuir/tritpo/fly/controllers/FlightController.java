package com.bsuir.tritpo.fly.controllers;


import com.bsuir.tritpo.fly.converters.FlightConverter;
import com.bsuir.tritpo.fly.models.api_models.FlightResponse;
import com.bsuir.tritpo.fly.models.api_models.airport_model.Airport;
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

    @Autowired
    private AirportsSingleton airportsSingleton;

    @Autowired
    public FlightController(FlightService flightService, FlightConverter flightConverter) {
        this.flightService = flightService;
        this.flightConverter = flightConverter;
    }

    @GetMapping(value = "/getAvailableFlights/{originPlace}/{destinationPlace}/{outboundPartialDate}")
    @ResponseBody
    public ResponseEntity getFlight(@PathVariable("originPlace") String originPlace,
                                    @PathVariable("destinationPlace") String destinationPlace,
                                    @PathVariable("outboundPartialDate") String outboundPartialDate) {
        FlightResponse response = null;
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

    @GetMapping(value = "/getAirports")
    @ResponseBody
    public ResponseEntity getAirports() {
        List<Airport> airports = null;
        try {
            airports = flightService.getAirports();
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        if (airports != null){
            return ResponseEntity.ok("ok");
        }
        return ResponseEntity.ok("ok");
    }
}