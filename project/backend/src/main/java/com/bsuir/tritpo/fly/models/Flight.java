package com.bsuir.tritpo.fly.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String origin_place;
    private String destination_place;
    private Date date;
    private double price;
    private boolean return_ticket;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private SalesOrder salesOrder;

    public Flight() {
    }

    public long getId() {
        return id;
    }

    public String getOrigin_place() {
        return origin_place;
    }

    public void setOrigin_place(String origin_place) {
        this.origin_place = origin_place;
    }

    public String getDestination_place() {
        return destination_place;
    }

    public void setDestination_place(String destination_place) {
        this.destination_place = destination_place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isReturn_ticket() {
        return return_ticket;
    }

    public void setReturn_ticket(boolean return_ticket) {
        this.return_ticket = return_ticket;
    }

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", origin_place='" + origin_place + '\'' +
                ", destination_place='" + destination_place + '\'' +
                ", date=" + date +
                ", price=" + price +
                ", return_ticket=" + return_ticket +
                ", salesOrder=" + salesOrder +
                '}';
    }
}
