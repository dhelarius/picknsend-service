package com.picknsend.customerservice.adapter.controller;

import com.picknsend.customerservice.adapter.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author dhelarius 28/6/2021
 * picknsend-costumer-service
 */
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/customers")
    public List<Map<String, Object>> findAllCustomer() {
        return customerService.findAllCustomer();
    }
}
