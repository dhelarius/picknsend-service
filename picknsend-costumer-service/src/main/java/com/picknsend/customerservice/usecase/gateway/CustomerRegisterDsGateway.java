package com.picknsend.customerservice.usecase.gateway;

import com.picknsend.customerservice.usecase.model.CustomerDsRequestModel;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
public interface CustomerRegisterDsGateway {

    boolean existByNpsv(String npsv);

    void save(CustomerDsRequestModel request);
}
