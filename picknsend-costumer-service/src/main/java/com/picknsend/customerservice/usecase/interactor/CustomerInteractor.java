package com.picknsend.customerservice.usecase.interactor;

import com.picknsend.customerservice.usecase.gateway.CustomerDsGateway;
import com.picknsend.customerservice.usecase.presenter.CustomerPresenter;

/**
 * @author dhelarius 4/7/2021
 * picknsend-costumer-service
 */

/**
 * Configura un caso de uso para que pueda realizar una de las distintas
 * operaciones sobre un cliente o una lista de clientes, ya sea, Crear, buscar,
 * actualizar o eliminar.
 */
public abstract class CustomerInteractor {

    private final CustomerDsGateway customerDsGateway;
    private final CustomerPresenter customerPresenter;

    /**
     * Construye un caso de uso para realizar operaciones sobre un cliente
     * o una lista de clientes.
     * @param customerDsGateway Contiene los métodos de contrato para realizar operaciones
     *                          sobre uno o varios clientes.
     * @param customerPresenter Presenta una respuesta luego de una solitud dada, si la respuesta
     *                          es satisfatoria devolverá con el método prepareSuccessView, de lo
     *                          contrario lo hará con prepareFailView.
     */
    public CustomerInteractor(CustomerDsGateway customerDsGateway,
                                     CustomerPresenter customerPresenter) {
        this.customerDsGateway = customerDsGateway;
        this.customerPresenter = customerPresenter;
    }

    /**
     * Devuelve un puerto que contiene las operaciones que se pueden realizar
     * sobre un cliente.
     * @return CustomerDsGateway
     */
    public CustomerDsGateway getCustomerDsGateway() {
        return customerDsGateway;
    }

    /**
     * Devuelve un presentador que notifica en la salida si una
     * solicitud es satisfactoria o fallida.
     * @return CustomerPresenter
     */
    public CustomerPresenter getCustomerPresenter() {
        return customerPresenter;
    }
}
