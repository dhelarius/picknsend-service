package com.picknsend.customerservice.usecase.interactor;

import com.picknsend.customerservice.domain.entity.customer.Customer;
import com.picknsend.customerservice.domain.entity.customer.CustomerFactory;
import com.picknsend.customerservice.usecase.gateway.CustomerDsGateway;
import com.picknsend.customerservice.usecase.gateway.CustomerUpdateBoundary;
import com.picknsend.customerservice.usecase.model.CustomerRequestDsModel;
import com.picknsend.customerservice.usecase.model.CustomerRequestModel;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import com.picknsend.customerservice.usecase.presenter.CustomerPresenter;

import java.time.LocalDateTime;

/**
 * @author dhelarius 3/7/2021
 * picknsend-costumer-service
 * Caso de uso para realizar actualizaciones de clientes.
 */
public class CustomerUpdaterInteractor extends CustomerInteractor implements CustomerUpdateBoundary {

    private final CustomerFactory customerFactory;

    /**
     * Construye un caso de uso para actualizar un cliente basado en los datos contenidos
     * en una solicitud.
     *
     * @param customerDsGateway Contiene los métodos de contrato para realizar operaciones
     *                          sobre uno o varios clientes.
     * @param customerPresenter Presenta una respuesta luego de una solitud dada, si la respuesta
     *                          es satisfatoria devolverá con el método prepareSuccessView, de lo
     *                          contrario lo hará con prepareFailView.
     * @param customerFactory Fábrica de objeto cliente.
     */
    public CustomerUpdaterInteractor(CustomerDsGateway customerDsGateway,
                                     CustomerPresenter customerPresenter,
                                     CustomerFactory customerFactory) {
        super(customerDsGateway, customerPresenter);
        this.customerFactory = customerFactory;
    }

    /**
     * Actualiza un cliente existente y devuelve una respuesta con los datos actualizados.
     *
     * @param request Solicitud con los datos necesario para actualizar un cliente.
     * @return CustomerResponseModel
     */
    @Override
    public CustomerResponseModel update(CustomerRequestModel request) {
        var customerDsGateway = getCustomerDsGateway();
        var customerPresenter = getCustomerPresenter();

        // Validar la existencia de un cliente según su identificador
        if(!customerDsGateway.existByNpsv(request.getNpsv())) {
            return customerPresenter.prepareFailView("El cliente no pudo ser encontrado, el npsv no existe.");
        }

        // En caso de existir crear un objeto cliente
        Customer customer = customerFactory.create(request.getNpsv(), request.getName(),
                request.getLastName(), request.getAddress(), request.getPhone(), request.getDni(),
                request.getEmail(), request.getCreationDate(), request.getStatus());

        // validar npsv
        if(!customer.npsvIsValid()) {
            customerPresenter.prepareFailView("No se ha encontrado código npsv, favor ingresar uno.");
        }

        // Validar nombre
        if(!customer.nameIsValid()) {
            customerPresenter.prepareFailView("Debe agregar un nombre.");
        }

        // Validar apellido
        if(!customer.lastNameIsValid()) {
            customerPresenter.prepareFailView("Debe agregar un apellido.");
        }

        LocalDateTime now = LocalDateTime.now();
        CustomerRequestDsModel customerDsRequest = new CustomerRequestDsModel(
                customer.getNpsv(), customer.getName(), customer.getLastName(),
                customer.getAddress(), customer.getPhone(), customer.getDNI(),
                customer.getEmail(), customer.getCreationDate(), customer.getStatus(), now);

        // Actualizar cliente
        customerDsGateway.update(customerDsRequest);

        // Devolver respuesta satisfactoria
        CustomerResponseModel response = new CustomerResponseModel(customerDsRequest.getNpsv(),
                customerDsRequest.getName(), customerDsRequest.getLastName(), customerDsRequest.getAddress(),
                customerDsRequest.getPhone(), customerDsRequest.getDni(), customerDsRequest.getEmail(),
                customerDsRequest.getCreationDate(), customerDsRequest.getStatus()/*, now.toString()*/);
        return customerPresenter.prepareSuccessView(response);
    }
}
