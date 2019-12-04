package com.bsuir.tritpo.fly.singletons;

import com.bsuir.tritpo.fly.models.DTOs.SalesOrderDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SalesOrderSingleton {
    private SalesOrderDTO salesOrder;

    public SalesOrderDTO getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrderDTO salesOrder) {
        this.salesOrder = salesOrder;
    }
}
