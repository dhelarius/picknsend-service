package com.picknsend.customerservice.usecase.gateway;

import com.picknsend.customerservice.usecase.model.CustomerRequestDsModel;

/**
 * @author dhelarius 2/7/2021
 * picknsend-costumer-service
 */
public interface CustomerRegisterDsGateway {

    boolean existByNpsv(String npsv);

    void save(CustomerRequestDsModel request);
}
