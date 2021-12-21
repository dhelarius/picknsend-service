package com.picknsend.customerservice.usecase.interactor;

import com.picknsend.customerservice.domain.entity.customer.Customer;
import com.picknsend.customerservice.domain.entity.customer.CustomerFactory;
import com.picknsend.customerservice.usecase.gateway.CustomerDsGateway;
import com.picknsend.customerservice.usecase.gateway.CustomerInputBoundary;
import com.picknsend.customerservice.usecase.model.CustomerRequestDsModel;
import com.picknsend.customerservice.usecase.model.CustomerRequestModel;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import com.picknsend.customerservice.usecase.presenter.CustomerPresenter;

import java.time.LocalDateTime;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */

/**
 * Caso de uso para crear clientes
 */
public class CustomerRegisterInteractor extends CustomerInteractor implements CustomerInputBoundary {

    private final CustomerFactory customerFactory;

    /**
     * Crea un nuevo caso de uso para registrar clientes.
     * @param customerDsGateway Contiene el método de contrato para crear un nuevo cliente.
     * @param customerPresenter Presenta una respuesta luego de una solitud dada, si la respuesta
     *                          es satisfatoria devolverá con el método prepareSuccessView, de lo
     *                          contrario lo harácon prepareFailView.
     * @param customerFactory Fábrica para la creación de un objeto cliente.
     */
    public CustomerRegisterInteractor(CustomerDsGateway customerDsGateway,
                                      CustomerPresenter customerPresenter,
                                      CustomerFactory customerFactory) {
        super(customerDsGateway, customerPresenter);
        this.customerFactory = customerFactory;
    }

    /**
     * Crea un cliente basado en los datos de la solicitud y devuelve una respuesta
     * con los datos del nuevo cliente.
     * @param request Solicitud que contiene los datos necesarios para crear un cliente.
     * @return CustomerResponseModel
     */
    @Override
    public CustomerResponseModel create(CustomerRequestModel request) {
        var customerDsGateway = getCustomerDsGateway();
        var customerPresenter = getCustomerPresenter();

        // Validar si el cliente existe
        if(customerDsGateway.existByNpsv(request.getNpsv())) {
            return customerPresenter.prepareFailView("El código npsv ya existe: No se ha podido " +
                                                        "crear el nuevo cliente.");
        }

        // Se crea el cliente en caso de que no exista
        Customer customer = customerFactory.create(request.getNpsv(), request.getName(),
                request.getLastName(), request.getAddress(), request.getPhone(), request.getDni(),
                request.getEmail(), request.getCreationDate(), request.getStatus());

        // Validar npsv
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

        // Crear el cliente
        customerDsGateway.save(customerDsRequest);

        // Devolver el resultado con repuesta satisfactoria
        CustomerResponseModel response = new CustomerResponseModel(customerDsRequest.getNpsv(),
                customerDsRequest.getName(), customerDsRequest.getLastName(), customerDsRequest.getAddress(),
                customerDsRequest.getPhone(), customerDsRequest.getDni(), customerDsRequest.getEmail(),
                customerDsRequest.getCreationDate(), customerDsRequest.getStatus()/*, now.toString()*/);
        return customerPresenter.prepareSuccessView(response);
    }
}
