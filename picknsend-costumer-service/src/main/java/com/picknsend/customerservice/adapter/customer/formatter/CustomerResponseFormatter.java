package com.picknsend.customerservice.adapter.customer.formatter;

import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import com.picknsend.customerservice.usecase.presenter.CustomerPresenter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Formatea la forma en como el servicio presenta la respuestas del servicio.
 *
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
public class CustomerResponseFormatter implements CustomerPresenter {

    /**
     * Formetea la devolución de una respuesta satisfactoria de un objeto cliente.
     * @param response Respuesta que será devuelta luego de una solicitud.
     * @return CustomerResponseModel
     */
    @Override
    public CustomerResponseModel prepareSuccessView(CustomerResponseModel response) {
        /*LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));*/
        return response;
    }

    /**
     * Formetea la devolución de una respuesta satisfactoria de una lista de clientes.
     * @param responses Respuesta que será devuelta luego de una solicitud.
     * @return {@code List<CustomerResponseModel>}
     */
    @Override
    public List<CustomerResponseModel> prepareSuccessView(List<CustomerResponseModel> responses) {
        return responses;
    }

    /**
     * Lanza una respuesta no satisfactoria con una descripción del error.
     * @param error Descripción de la excepción a error.
     * @return CustomerResponseModel
     */
    @Override
    public CustomerResponseModel prepareFailView(String error) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, error);
    }
}
