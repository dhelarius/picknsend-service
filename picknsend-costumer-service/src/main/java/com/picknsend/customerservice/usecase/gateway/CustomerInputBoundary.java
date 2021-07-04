package com.picknsend.customerservice.usecase.gateway;

import com.picknsend.customerservice.usecase.model.CustomerRequestModel;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
/**
 * Crea un limite de entrada para la solicitud de creación de clientes
 */
public interface CustomerInputBoundary {

    /**
     * Toma la solicitud de datos de un cliente para crearlo y devuelve una
     * respuesta exitosa con los datos ya procesado.
     * @param request Solicitud que contiene los datos necesarios para crear un cliente.
     * @return CustomerResponseModel
     */
    CustomerResponseModel create(CustomerRequestModel request);
}

