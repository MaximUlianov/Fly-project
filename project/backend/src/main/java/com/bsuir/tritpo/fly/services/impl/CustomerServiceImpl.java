package com.bsuir.tritpo.fly.services.impl;

import com.bsuir.tritpo.fly.models.CustomerDTO;
import com.bsuir.tritpo.fly.services.CustomerService;
import com.bsuir.tritpo.fly.singletons.CustomerSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerSingleton customerSingleton;

    @Autowired
    public CustomerServiceImpl(CustomerSingleton customerSingleton) {
        this.customerSingleton = customerSingleton;
    }

    @Override
    public CustomerDTO registerCustomer(CustomerDTO customer) {
        customerSingleton.setCustomer(customer);
        return customerSingleton.getCustomer();
    }

    @Override
    public CustomerDTO getActiveCustomer() {
        return customerSingleton.getCustomer();
    }
}
