package com.picknsend.customerservice.adapter.controller;

import com.picknsend.customerservice.usecase.gateway.CustomerInputBoundary;
import com.picknsend.customerservice.usecase.gateway.CustomerOutputBoundary;
import com.picknsend.customerservice.usecase.model.CustomerRequestModel;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dhelarius 28/6/2021
 * picknsend-costumer-service
 */
@RestController
public class CustomerController {

    private final CustomerInputBoundary customerInputBoundary;
    private final CustomerOutputBoundary customerOutputBoundary;

    public CustomerController(CustomerInputBoundary gateway,
                              CustomerOutputBoundary output) {
        this.customerInputBoundary = gateway;
        this.customerOutputBoundary = output;
    }

    @PostMapping(value = "/customer/create")
    public CustomerResponseModel create(@RequestBody CustomerRequestModel request) {
        return customerInputBoundary.create(request);
    }

    @GetMapping(value = "/customers")
    public List<CustomerResponseModel> findAll() {
        return customerOutputBoundary.findAll();
    }
}
