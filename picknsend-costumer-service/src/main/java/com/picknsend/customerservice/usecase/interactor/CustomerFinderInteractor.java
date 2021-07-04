package com.picknsend.customerservice.usecase.interactor;

import com.picknsend.customerservice.usecase.gateway.CustomerDsGateway;
import com.picknsend.customerservice.usecase.gateway.CustomerOutputBoundary;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import com.picknsend.customerservice.usecase.presenter.CustomerPresenter;

/**
 * @author dhelarius 3/7/2021
 * picknsend-costumer-service
 */

/**
 * Caso de uso para la búsqueda de un cliente
 */
public class CustomerFinderInteractor implements CustomerOutputBoundary {

    private final CustomerDsGateway customerDsGateway;
    private final CustomerPresenter customerPresenter;

    /**
     * Construye en caso de uso para realizar la búsqueda de un cliente, basada
     * en su identificador asociado.
     * @param customerDsGateway Contiene el método de contrato para la búsqueda de cada cliente.
     * @param customerPresenter Presenta una respuesta luego de una solitud dada, si la respuesta
     *                          es satisfatoria devolverá con el método prepareSuccessView, de lo
     *                          contrario lo hará con prepareFailView.
     */
    public CustomerFinderInteractor(CustomerDsGateway customerDsGateway,
                                    CustomerPresenter customerPresenter) {
        this.customerDsGateway = customerDsGateway;
        this.customerPresenter = customerPresenter;
    }

    /**
     * Devuelve un cliente basado en su identificador asociado.
     * @param npsv Identica a un cliente en la base de datos.
     * @return CustomerResponseModel
     */
    @Override
    public CustomerResponseModel findByNpsv(String npsv) {
        // Validar si el cliente existe
        if(!customerDsGateway.existByNpsv(npsv)) {
            return customerPresenter.prepareFailView("El cliente no pudo ser encontrado, el npsv no existe.");
        }

        // En caso de existir devolver respuesta satisfactoria
        var response = customerDsGateway.findByNpsv(npsv);
        return customerPresenter.prepareSuccessView(response);
    }
}
