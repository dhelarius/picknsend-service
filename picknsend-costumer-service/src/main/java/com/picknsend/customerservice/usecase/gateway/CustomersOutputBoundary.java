package com.picknsend.customerservice.usecase.gateway;

import com.picknsend.customerservice.usecase.model.CustomerResponseModel;

import java.util.List;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */

/**
 * Crea un limite de salida para la búsqueda clientes.
 */
public interface CustomersOutputBoundary {

    /**
     * Contrato para devolver todos los clientes que están registrados.
     * @return List<CustomerResponse>
     */
    List<CustomerResponseModel> findAll();
}
