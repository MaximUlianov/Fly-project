package com.bsuir.tritpo.fly.services;

import com.bsuir.tritpo.fly.models.CustomerDTO;

public interface  CustomerService {

    CustomerDTO registerCustomer(CustomerDTO customer);
    CustomerDTO getActiveCustomer();
}
