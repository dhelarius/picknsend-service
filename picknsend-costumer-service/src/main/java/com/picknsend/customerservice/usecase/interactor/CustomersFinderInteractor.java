package com.picknsend.customerservice.usecase.interactor;

import com.picknsend.customerservice.usecase.gateway.CustomerDsGateway;
import com.picknsend.customerservice.usecase.gateway.CustomersOutputBoundary;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import com.picknsend.customerservice.usecase.presenter.CustomerPresenter;

import java.util.List;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */

/**
 * Caso de uso para devolver una lista de clientes.
 */
public class CustomersFinderInteractor extends CustomerInteractor implements CustomersOutputBoundary {

    /**
     * Construye un caso de uso que para buscar varios clientes
     * @param customerDsGateway Contiene el método de contrato para realizar la búsqueda de clientes.
     * @param customerPresenter Presenta una respuesta luego de una solitud dada, si la respuesta
     *                          es satisfatoria devolverá con el método prepareSuccessView, de lo
     *                          contrario lo hará con prepareFailView.
     */
    public CustomersFinderInteractor(CustomerDsGateway customerDsGateway,
                                     CustomerPresenter customerPresenter) {
        super(customerDsGateway, customerPresenter);
    }

    /**
     * Devuelve una lista de clientes
     * @return {@code List<CustomerResponseModel>}
     */
    @Override
    public List<CustomerResponseModel> findAll() {
        var response = getCustomerDsGateway().findAll();
        return getCustomerPresenter().prepareSuccessView(response);
    }
}
