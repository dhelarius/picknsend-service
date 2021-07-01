package com.picknsend.customerservice.usecase.gateway;

import com.picknsend.customerservice.usecase.model.CustomerRequestModel;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
public interface CustomerInputBoundary {
    CustomerResponseModel create(CustomerRequestModel request);
}

