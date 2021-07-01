package com.picknsend.customerservice.usecase.gateway;

import com.picknsend.customerservice.usecase.model.CustomerResponseModel;

import java.util.List;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
public interface CustomerOutputBoundary {
    List<CustomerResponseModel> read();
}
