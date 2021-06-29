package com.picknsend.costumerservice.adapter.controller;

import com.picknsend.costumerservice.adapter.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
@RestController
public class CustomerServiceController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/customers")
    public List<Map<String, Object>> findAllCustomer() {
        return customerService.findAllCustomer();
    }
}
