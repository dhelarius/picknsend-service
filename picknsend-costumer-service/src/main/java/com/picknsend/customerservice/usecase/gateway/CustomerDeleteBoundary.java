package com.picknsend.customerservice.usecase.gateway;

import com.picknsend.customerservice.usecase.model.CustomerResponseModel;

/**
 * @author dhelarius 2/7/2021
 * picknsend-costumer-service
 * Crea un limite de entrada para la eliminación de clientes
 */
public interface CustomerDeleteBoundary {

    /**
     * Toma un identificador de un cliente y lo elimina a partir de este.
     * @param npsv Identica a un cliente en la base de datos
     * @return CustomerResponseModel
     */
    CustomerResponseModel delete(String npsv);
}
