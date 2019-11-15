package com.bsuir.tritpo.fly.controllers;

import com.bsuir.tritpo.fly.models.Babki;
import com.bsuir.tritpo.fly.models.Flight;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {
    /*@Autowired
    private FlightServiceImpl flightService;
    @Autowired
    private TicketServiceImpl ticketService;*/

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity getFlight() throws Exception{
        HttpResponse<String> response = Unirest.get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/currencies")
                .header("X-RapidAPI-Host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .header("X-RapidAPI-Key", "918e2f47b8msh1088195f5096426p125566jsnecd9c44ebe43")
                .asObject(String.class);
        Gson g = new Gson();
        Babki babki = g.fromJson(response.getBody(), Babki.class);
        /*RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-RapidAPI-Host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com");
        headers.add("X-RapidAPI-Key", "918e2f47b8msh1088195f5096426p125566jsnecd9c44ebe43");
        Babki govno = new Babki();
        HttpEntity<Babki> entity = new HttpEntity<>(govno, headers);
        Babki babki = restTemplate.exchange(
                "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/currencies", HttpMethod.GET, entity, Babki.class).getBody();*/
        return ResponseEntity.ok("ok");
    }

   /* @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Flight> deleteFlight(@PathVariable("id") Integer flightId){
        Flight flight = this.flightService.getById(flightId);

        if (flight == null){
            return new ResponseEntity<Flight>(HttpStatus.NOT_FOUND);
        }

        this.flightService.delete(flightId);
        return new ResponseEntity<Flight>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Flight> saveFlight(@RequestBody Flight flight){
        this.flightService.save(flight);
        return new ResponseEntity<Flight>(flight, HttpStatus.CREATED);
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Flight>> getAllFlights(){
        List<Flight> flights = this.flightService.getAll();

        if (flights.isEmpty()){
            return new ResponseEntity<List<Flight>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
    }

    @GetMapping("/filter/{dateFrom}/{dateTo}/{fromPlace}/{toPlace}")
    public ResponseEntity<List<Flight>> filter (@PathVariable("dateFrom") String departureTimeFromUrl,
                                                @PathVariable("dateTo") String departureTimeToUrl,
                                                @PathVariable("fromPlace") String fromPlace,
                                                @PathVariable("toPlace") String toPlace) throws ParseException {
        List<Flight> flights = this.flightService.filter(departureTimeFromUrl, departureTimeToUrl, fromPlace, toPlace);

        if (flights.isEmpty()){
            return new ResponseEntity<List<Flight>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
    }*/
}