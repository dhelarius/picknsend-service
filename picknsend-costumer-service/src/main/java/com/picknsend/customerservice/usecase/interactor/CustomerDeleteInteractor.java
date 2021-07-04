package com.picknsend.customerservice.usecase.interactor;

import com.picknsend.customerservice.usecase.gateway.CustomerDeleteBoundary;
import com.picknsend.customerservice.usecase.gateway.CustomerDsGateway;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import com.picknsend.customerservice.usecase.presenter.CustomerPresenter;

/**
 * @author dhelarius 2/7/2021
 * picknsend-costumer-service
 */

/**
 * Caso de uso para eliminar clientes
 */
public class CustomerDeleteInteractor extends CustomerInteractor implements CustomerDeleteBoundary{

    /**
     * Construye un caso de uso para eliminar clientes según su identificador asociado.
     * @param customerDsGateway Contiene los métodos de contrato para realizar operaciones
     *                          sobre uno o varios clientes.
     * @param customerPresenter Presenta una respuesta luego de una solitud dada, si la respuesta
     *                          es satisfatoria devolverá con el método prepareSuccessView, de lo
     *                          contrario lo hará con prepareFailView
     */
    public CustomerDeleteInteractor(CustomerDsGateway customerDsGateway,
                                    CustomerPresenter customerPresenter) {
        super(customerDsGateway, customerPresenter);
    }

    /**
     * Elimina un cliente según su identificador asociado
     * @param npsv Identica a un cliente en la base de datos
     * @return CustomerResponseModel
     */
    @Override
    public CustomerResponseModel delete(String npsv) {
        var customerDsGateway = getCustomerDsGateway();
        var customerPresenter = getCustomerPresenter();

        // Se valida si el cliente existe
        if(!customerDsGateway.existByNpsv(npsv)) {
            return customerPresenter.prepareFailView("No se ha podido eliminar el cliente, el npsv no existe.");
        }

        // En caso de ser encontrado es eliminado de la base de datos
        var response = customerDsGateway.delete(npsv);
        return customerPresenter.prepareSuccessView(response);
    }
}
