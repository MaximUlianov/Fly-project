package com.bsuir.tritpo.fly.models.api_models;

import java.io.Serializable;
import java.util.List;

public class FlightDate implements Serializable {
    private List<AvailableDate> OutboundDates;
    private List<AvailableDate> InboundDates;

    public FlightDate() {
    }

    public List<AvailableDate> getOutboundDates() {
        return OutboundDates;
    }

    public void setOutboundDates(List<AvailableDate> outboundDates) {
        OutboundDates = outboundDates;
    }

    public List<AvailableDate> getInboundDates() {
        return InboundDates;
    }

    public void setInboundDates(List<AvailableDate> inboundDates) {
        InboundDates = inboundDates;
    }
}
