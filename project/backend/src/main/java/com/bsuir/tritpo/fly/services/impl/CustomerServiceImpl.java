package com.bsuir.tritpo.fly.services.impl;

import com.bsuir.tritpo.fly.models.CustomerDTO;
import com.bsuir.tritpo.fly.models.DTOs.SalesOrderDTO;
import com.bsuir.tritpo.fly.services.CustomerService;
import com.bsuir.tritpo.fly.singletons.CustomerSingleton;
import com.bsuir.tritpo.fly.singletons.SalesOrderSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerSingleton customerSingleton;
    private SalesOrderSingleton salesOrderSingleton;

    @Autowired
    public CustomerServiceImpl(CustomerSingleton customerSingleton, SalesOrderSingleton salesOrderSingleton) {
        this.customerSingleton = customerSingleton;
        this.salesOrderSingleton = salesOrderSingleton;
    }

    @Override
    public CustomerDTO registerCustomer(CustomerDTO customer) {
        customerSingleton.setCustomer(customer);
        SalesOrderDTO salesOrderDTO = salesOrderSingleton.getSalesOrder();
        salesOrderDTO.setCustomer(customer);
        salesOrderSingleton.setSalesOrder(salesOrderDTO);
        return customerSingleton.getCustomer();
    }

    @Override
    public CustomerDTO getActiveCustomer() {
        return customerSingleton.getCustomer();
    }
}
