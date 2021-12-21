package com.picknsend.customerservice.usecase.gateway;

import com.picknsend.customerservice.usecase.model.CustomerResponseModel;

/**
 * @author dhelarius 6/12/2021
 * picknsend-costumer-service
 * Define el método necesario para inactivar un cliente a partir de
 * su identificador.
 */
public interface CustomerInactivateBoundary {

    /**
     * @param npsv Toma el identificador de un cliente y lo inactiva a partir de este.
     * @return El cliente recientemente inactivado.
     */
    CustomerResponseModel inactivate(String npsv);
}
