package com.picknsend.customerservice.usecase.gateway;

import com.picknsend.customerservice.usecase.model.CustomerRequestModel;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;

/**
 * @author dhelarius 3/7/2021
 * picknsend-costumer-service
 */

/**
 * Crea un limite de entrada para actualizar un cliente ya existente.
 */
public interface CustomerUpdateBoundary {

    /**
     * Contrato para devolver un cliente con sus datos ya actualizados
     * a partir de una solicitud
     * @param request Solicitud con los datos necesario para actualizar a un cliente.
     * @return CustomerResponseModel
     */
    CustomerResponseModel update(CustomerRequestModel request);
}
