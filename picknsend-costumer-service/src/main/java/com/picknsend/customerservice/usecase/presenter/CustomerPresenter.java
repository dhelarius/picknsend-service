package com.picknsend.customerservice.usecase.presenter;

import com.picknsend.customerservice.usecase.model.CustomerResponseModel;

import java.util.List;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */

/**
 * Contiene los métodos para formatear la manera en como se presentan
 * las respuestas a la solicitudes que se realizan al servicio.
 */
public interface CustomerPresenter {

    /**
     * Devuelve un cliente con una respuesta satisfactoria.
     *
     * @param response Respuesta que será devuelta luego de una solicitud.
     * @return CustomerResponseModel
     */
    CustomerResponseModel prepareSuccessView(CustomerResponseModel response);

    /**
     * Devuelve varios clientes con una respuesta satisfactoria.
     *
     * @param responses Respuesta que será devuelta luego de una solicitud.
     * @return {@code List<CustomerResponseModel>}
     */
    List<CustomerResponseModel> prepareSuccessView(List<CustomerResponseModel> responses);

    /**
     * Devuelve una respuesta no satisfactoria provocada por una excepción o un error.
     *
     * @param error Descripción de la excepción a error.
     * @return CustomerResponseModel
     */
    CustomerResponseModel prepareFailView(String error);
}
