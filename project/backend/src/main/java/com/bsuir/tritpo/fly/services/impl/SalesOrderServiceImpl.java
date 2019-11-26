package com.bsuir.tritpo.fly.services.impl;

import com.bsuir.tritpo.fly.models.DTOs.ExtrasDTO;
import com.bsuir.tritpo.fly.models.DTOs.FlightDTO;
import com.bsuir.tritpo.fly.models.DTOs.SalesOrderDTO;
import com.bsuir.tritpo.fly.services.SalesOrderService;
import com.bsuir.tritpo.fly.singletons.CustomerSingleton;
import com.bsuir.tritpo.fly.singletons.SalesOrderSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {

    private SalesOrderSingleton salesOrderSingleton;
    private CustomerSingleton customerSingleton;

    @Autowired
    public SalesOrderServiceImpl(SalesOrderSingleton salesOrderSingleton, CustomerSingleton customerSingleton) {
        this.salesOrderSingleton = salesOrderSingleton;
        this.customerSingleton = customerSingleton;
    }

    @Override
    public FlightDTO buyTicket(FlightDTO flightDTO) {
        SalesOrderDTO salesOrderDTO = salesOrderSingleton.getSalesOrder();
        if (flightDTO.isBack()) {
            salesOrderDTO.setTicketBack(flightDTO);
        } else {
            salesOrderDTO.setTicketThere(flightDTO);
        }
        salesOrderSingleton.setSalesOrder(salesOrderDTO);
        return flightDTO;
    }

    @Override
    public ExtrasDTO buyExtras(ExtrasDTO extrasDTO) {
        SalesOrderDTO salesOrderDTO = salesOrderSingleton.getSalesOrder();
        salesOrderDTO.setExtras(extrasDTO);
        salesOrderSingleton.setSalesOrder(salesOrderDTO);
        return extrasDTO;
    }

    @Override
    public SalesOrderDTO getActiveSalesOrder() {
        return salesOrderSingleton.getSalesOrder();
    }

    @PostConstruct
    private void initializeSalesOrder() {
        SalesOrderDTO salesOrderDTO = new SalesOrderDTO();
        salesOrderSingleton.setSalesOrder(salesOrderDTO);
    }

    @Override
    public void clearAll() {
        salesOrderSingleton.setSalesOrder(new SalesOrderDTO());
        customerSingleton.setCustomer(null);
    }
}
