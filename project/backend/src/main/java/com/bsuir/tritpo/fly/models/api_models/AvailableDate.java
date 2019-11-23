package com.bsuir.tritpo.fly.models.api_models;

import java.io.Serializable;
import java.util.List;

public class AvailableDate implements Serializable {
    private String PartialDate;
    private List<Integer> QuoteIds;
    private double Price;
    private String QuoteDateTime;

    public AvailableDate() {
    }

    public String getPartialDate() {
        return PartialDate;
    }

    public void setPartialDate(String partialDate) {
        PartialDate = partialDate;
    }

    public List<Integer> getQuoteIds() {
        return QuoteIds;
    }

    public void setQuoteIds(List<Integer> quoteIds) {
        QuoteIds = quoteIds;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getQuoteDateTime() {
        return QuoteDateTime;
    }

    public void setQuoteDateTime(String quoteDateTime) {
        QuoteDateTime = quoteDateTime;
    }
}
