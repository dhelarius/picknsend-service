package com.picknsend.customerservice.usecase.gateway;

import com.picknsend.customerservice.usecase.model.CustomerResponseModel;

import java.util.List;

/**
 * @author dhelarius 2/7/2021
 * picknsend-costumer-service
 */
public interface CustomersFinderDsGateway {
    List<CustomerResponseModel> findAll();
}
