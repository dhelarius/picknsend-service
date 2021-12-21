package com.picknsend.customerservice.usecase.interactor;

import com.picknsend.customerservice.usecase.gateway.CustomerDsGateway;
import com.picknsend.customerservice.usecase.gateway.CustomerInactivateBoundary;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import com.picknsend.customerservice.usecase.presenter.CustomerPresenter;

/**
 * @author dhelarius 6/12/2021
 * picknsend-costumer-service
 * Caso de uso para inactivar un cliente.
 */
public class CustomerInactivateInteractor extends CustomerInteractor implements CustomerInactivateBoundary {
    /**
     * Construye un caso de uso para realizar operaciones sobre un cliente
     * o una lista de clientes.
     *
     * @param customerDsGateway Contiene los métodos de contrato para realizar operaciones
     *                          sobre uno o varios clientes.
     * @param customerPresenter Presenta una respuesta luego de una solitud dada, si la respuesta
     *                          es satisfatoria devolverá con el método prepareSuccessView, de lo
     *                          contrario lo hará con prepareFailView.
     */
    public CustomerInactivateInteractor(CustomerDsGateway customerDsGateway,
                                        CustomerPresenter customerPresenter) {
        super(customerDsGateway, customerPresenter);
    }

    @Override
    public CustomerResponseModel inactivate(String npsv) {
        var customerDsGateway = getCustomerDsGateway();
        var customerPresenter = getCustomerPresenter();

        // Se valida si el cliente existe
        if(!customerDsGateway.existByNpsv(npsv)) {
            return customerPresenter.prepareFailView("No se ha podido inactivar el cliente, el npsv no existe.");
        }

        // En caso de ser encontrado es inactivado y devuelto con su nuevo estado
        var response = customerDsGateway.inactivate(npsv);
        return customerPresenter.prepareSuccessView(response);
    }
}
