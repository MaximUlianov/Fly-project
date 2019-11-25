package com.bsuir.tritpo.fly.controllers;


import com.bsuir.tritpo.fly.models.CustomerDTO;
import com.bsuir.tritpo.fly.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private CustomerService customerService ;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public ResponseEntity registerCustomer(@RequestBody CustomerDTO customer){
        return ResponseEntity.ok(customerService.registerCustomer(customer));
    }

    @GetMapping(value = "/getActive")
    @ResponseBody
    public ResponseEntity getActiveCustomer(){
        return ResponseEntity.ok(customerService.getActiveCustomer());
    }
}
