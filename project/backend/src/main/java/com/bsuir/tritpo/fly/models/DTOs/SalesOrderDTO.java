package com.bsuir.tritpo.fly.models.DTOs;

import com.bsuir.tritpo.fly.models.CustomerDTO;

public class SalesOrderDTO {
    private  FlightDTO ticketThere;
    private FlightDTO ticketBack;
    private CustomerDTO customer;
    private ExtrasDTO extras;
    private double totalPrice;

    public SalesOrderDTO() {
    }

    public FlightDTO getTicketThere() {
        return ticketThere;
    }

    public void setTicketThere(FlightDTO ticketThere) {
        this.ticketThere = ticketThere;
    }

    public FlightDTO getTicketBack() {
        return ticketBack;
    }

    public void setTicketBack(FlightDTO ticketBack) {
        this.ticketBack = ticketBack;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ExtrasDTO getExtras() {
        return extras;
    }

    public void setExtras(ExtrasDTO extras) {
        this.extras = extras;
    }
}
