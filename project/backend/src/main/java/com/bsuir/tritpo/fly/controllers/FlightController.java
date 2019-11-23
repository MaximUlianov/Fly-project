package com.bsuir.tritpo.fly.controllers;


import com.bsuir.tritpo.fly.models.api_models.FlightResponse;
import com.bsuir.tritpo.fly.services.FlightService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    private FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping(value = "/getAvailable/{originPlace}/{destinationPlace}/{outboundPartialDate}")
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
}