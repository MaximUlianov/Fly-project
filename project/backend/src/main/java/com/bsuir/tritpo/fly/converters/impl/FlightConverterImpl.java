package com.bsuir.tritpo.fly.converters.impl;

import com.bsuir.tritpo.fly.converters.FlightConverter;
import com.bsuir.tritpo.fly.models.DTOs.AirportSuggestionDto;
import com.bsuir.tritpo.fly.models.DTOs.FlightDTO;
import com.bsuir.tritpo.fly.models.DTOs.QuoteDTO;
import com.bsuir.tritpo.fly.models.api_models.Carrier;
import com.bsuir.tritpo.fly.models.api_models.FlightResponse;
import com.bsuir.tritpo.fly.models.api_models.Quote;
import com.bsuir.tritpo.fly.models.api_models.airport_model.Airport;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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

    @Override
    public FlightDTO convertFlightResponseToDTO(FlightResponse flightResponse) {
        if (flightResponse != null) {
            FlightDTO flightDTO = new FlightDTO();
            if (flightResponse.getPlaces() != null) {
                flightDTO.setOriginCity(flightResponse.getPlaces().get(0).getCityName());
                flightDTO.setOriginCode(flightResponse.getPlaces().get(0).getIataCode());
                flightDTO.setDestinationCity(flightResponse.getPlaces().get(1).getCityName());
                flightDTO.setDestinationCode(flightResponse.getPlaces().get(1).getIataCode());
            }
            if (!CollectionUtils.isEmpty(flightResponse.getQuotes())
            && !CollectionUtils.isEmpty(flightResponse.getCarriers())) {
                flightDTO.setQuotes(convertQuotesToDTOs(flightResponse.getQuotes(),
                        flightResponse.getCarriers()));
            }
            return flightDTO;

        }
        return null;
    }

    private List<QuoteDTO> convertQuotesToDTOs(List<Quote> quotes, List<Carrier> carriers) {
        List<QuoteDTO> quoteDTOS = new ArrayList<>();
        quotes.forEach(quote -> {
            QuoteDTO quoteDTO = new QuoteDTO();
            quoteDTO.setDepartureDate(parseDate(quote.getOutboundLeg().getDepartureDate())[0]);
            quoteDTO.setDepartureTime(parseDate(quote.getQuoteDateTime())[1]);
            quoteDTO.setPrice(quote.getMinPrice());
            quoteDTO.setCarriers(carriers
            .stream()
            .filter(carrier -> quote.getOutboundLeg().getCarrierIds().contains(carrier.getCarrierId()))
            .map(Carrier::getName)
            .collect(Collectors.toList()));
            quoteDTOS.add(quoteDTO);
        });
        return quoteDTOS;
    }

    private String[] parseDate(String date) {
        return date.split("T");
    }
}
