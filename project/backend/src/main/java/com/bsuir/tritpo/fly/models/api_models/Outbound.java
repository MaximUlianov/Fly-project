package com.bsuir.tritpo.fly.models.api_models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class  Outbound implements Serializable {
    private List<Integer> CarrierIds;
    private int OriginalId;
    private int DestinationId;
    private String DepartureDate;

    public Outbound() {
    }

    public List<Integer> getCarrierIds() {
        return CarrierIds;
    }

    public void setCarrierIds(List<Integer> carrierIds) {
        CarrierIds = carrierIds;
    }

    public int getOriginalId() {
        return OriginalId;
    }

    public void setOriginalId(int originalId) {
        OriginalId = originalId;
    }

    public int getDestinationId() {
        return DestinationId;
    }

    public void setDestinationId(int destinationId) {
        DestinationId = destinationId;
    }

    public String getDepartureDate() {
        return DepartureDate;
    }

    public void setDepartureDate(String departureDate) {
        DepartureDate = departureDate;
    }
}
