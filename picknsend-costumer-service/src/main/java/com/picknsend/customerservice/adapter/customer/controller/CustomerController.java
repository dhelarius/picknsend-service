package com.picknsend.customerservice.adapter.customer.controller;

import com.picknsend.customerservice.usecase.gateway.*;
import com.picknsend.customerservice.usecase.model.CustomerRequestModel;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
@RestController
public class CustomerController {

    private final CustomerInputBoundary customerInputBoundary;
    private final CustomerOutputBoundary customerOutputBoundary;
    private final CustomersOutputBoundary customersOutputBoundary;
    private final CustomerUpdateBoundary customerUpdateBoundary;
    private final CustomerDeleteBoundary customerDeleteBoundary;

    public CustomerController(CustomerInputBoundary customerInputBoundary,
                              CustomerOutputBoundary customerOutputBoundary,
                              CustomersOutputBoundary customersOutputBoundary,
                              CustomerUpdateBoundary customerUpdateBoundary,
                              CustomerDeleteBoundary customerDeleteBoundary) {
        this.customerInputBoundary = customerInputBoundary;
        this.customerOutputBoundary = customerOutputBoundary;
        this.customerUpdateBoundary = customerUpdateBoundary;
        this.customersOutputBoundary = customersOutputBoundary;
        this.customerDeleteBoundary = customerDeleteBoundary;
    }

    @PostMapping(value = "/customer/create")
    public ResponseEntity<CustomerResponseModel> create(@RequestBody CustomerRequestModel request) {
        var response = customerInputBoundary.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "/customer/{npsv}")
    public ResponseEntity<CustomerResponseModel> findByNpsv(@PathVariable String npsv) {
        var response = customerOutputBoundary.findByNpsv(npsv);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/customer")
    public ResponseEntity<List<CustomerResponseModel>> findAll() {
        var response = customersOutputBoundary.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(value = "/customer")
    public ResponseEntity<CustomerResponseModel> update(@RequestBody CustomerRequestModel request) {
        var response = customerUpdateBoundary.update(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = "/customer/{npsv}")
    public ResponseEntity<CustomerResponseModel> delete(@PathVariable String npsv) {
        var response = customerDeleteBoundary.delete(npsv);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}
