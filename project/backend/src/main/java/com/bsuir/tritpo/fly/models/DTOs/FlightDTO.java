package com.bsuir.tritpo.fly.models.DTOs;

import java.util.List;

public class  FlightDTO {
    List<QuoteDTO> quotes;
    private String originCity;
    private String originCode;
    private String destinationCity;
    private String destinationCode;
    private boolean back;

    public FlightDTO() {
    }

    public List<QuoteDTO> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<QuoteDTO> quotes) {
        this.quotes = quotes;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getOriginCode() {
        return originCode;
    }

    public void setOriginCode(String originCode) {
        this.originCode = originCode;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public boolean isBack() {
        return back;
    }

    public void setBack(boolean back) {
        this.back = back;
    }
}
