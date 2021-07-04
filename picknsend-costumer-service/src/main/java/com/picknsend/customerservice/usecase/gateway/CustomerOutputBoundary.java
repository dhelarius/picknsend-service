package com.picknsend.customerservice.usecase.gateway;

import com.picknsend.customerservice.usecase.model.CustomerResponseModel;

/**
 * @author dhelarius 3/7/2021
 * picknsend-costumer-service
 */

/**
 * Crea un limite de salida para la búsqueda de un cliente mediante su identificador
 */
public interface CustomerOutputBoundary {

    /**
     * Contrato para la búsqueda de un cliente mediante su identificador.
     * @param npsv Identica a un cliente en la base de datos.
     * @return CustomerResponseModel
     */
    CustomerResponseModel findByNpsv(String npsv);
}
