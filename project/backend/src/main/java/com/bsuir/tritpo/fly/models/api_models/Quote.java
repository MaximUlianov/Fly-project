package com.bsuir.tritpo.fly.models.api_models;

import java.io.Serializable;
import java.util.Date;

public class Quote implements Serializable {
    private int QuoteId;
    private double MinPrice;
    private boolean Direct;
    private Outbound OutboundLeg;
    private String QuoteDateTime;

    public Quote() {
    }

    public int getQuoteId() {
        return QuoteId;
    }

    public void setQuoteId(int quoteId) {
        QuoteId = quoteId;
    }

    public double getMinPrice() {
        return MinPrice;
    }

    public void setMinPrice(double minPrice) {
        MinPrice = minPrice;
    }

    public boolean isDirect() {
        return Direct;
    }

    public void setDirect(boolean direct) {
        Direct = direct;
    }

    public Outbound getOutboundLeg() {
        return OutboundLeg;
    }

    public void setOutboundLeg(Outbound outboundLeg) {
        OutboundLeg = outboundLeg;
    }

    public String getQuoteDateTime() {
        return QuoteDateTime;
    }

    public void setQuoteDateTime(String quoteDateTime) {
        QuoteDateTime = quoteDateTime;
    }
}
