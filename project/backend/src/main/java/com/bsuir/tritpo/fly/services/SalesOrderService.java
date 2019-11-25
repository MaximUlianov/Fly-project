package com.bsuir.tritpo.fly.services;

import com.bsuir.tritpo.fly.models.DTOs.ExtrasDTO;
import com.bsuir.tritpo.fly.models.DTOs.FlightDTO;
import com.bsuir.tritpo.fly.models.DTOs.SalesOrderDTO;

public interface SalesOrderService {

    FlightDTO buyTicket(FlightDTO flightDTO);
    ExtrasDTO buyExtras(ExtrasDTO extrasDTO);
    SalesOrderDTO getActiveSalesOrder();
}
