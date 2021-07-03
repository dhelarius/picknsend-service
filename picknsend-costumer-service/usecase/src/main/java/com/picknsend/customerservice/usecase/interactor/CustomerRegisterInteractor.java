package com.picknsend.customerservice.usecase.interactor;

import com.picknsend.customerservice.domain.Customer;
import com.picknsend.customerservice.domain.CustomerFactory;
import com.picknsend.customerservice.usecase.gateway.CustomerInputBoundary;
import com.picknsend.customerservice.usecase.model.CustomerRequestDsModel;
import com.picknsend.customerservice.usecase.model.CustomerRequestModel;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import com.picknsend.customerservice.usecase.presenter.CustomerPresenter;
import com.picknsend.customerservice.usecase.gateway.CustomerRegisterDsGateway;

import java.time.LocalDateTime;

/**
 * @author dhelarius 2/7/2021
 * picknsend-costumer-service
 */
public class CustomerRegisterInteractor implements CustomerInputBoundary {

    private CustomerRegisterDsGateway customerRegisterDsGateway;
    private CustomerPresenter customerPresenter;
    private CustomerFactory customerFactory;

    public CustomerRegisterInteractor() {}

    public CustomerRegisterInteractor(CustomerRegisterDsGateway customerRegisterDsGateway,
                                      CustomerPresenter customerPresenter,
                                      CustomerFactory customerFactory) {
        this.customerRegisterDsGateway = customerRegisterDsGateway;
        this.customerPresenter = customerPresenter;
        this.customerFactory = customerFactory;
    }

    @Override
    public CustomerResponseModel create(CustomerRequestModel request) {
        if(customerRegisterDsGateway.existByNpsv(request.getNpsv())) {
            return customerPresenter.prepareFailView("El código npsv ya existe.");
        }

        Customer customer = customerFactory.create(request.getNpsv(), request.getName(),
                request.getLastName(), request.getAddress(), request.getPhone(), request.getDni(),
                request.getEmail(), request.getCreationDate(), request.getStatus());

        if(!customer.npsvIsValid()) {
            customerPresenter.prepareFailView("No se ha encontrado código npsv, favor ingresar uno.");
        }

        if(!customer.nameIsValid()) {
            customerPresenter.prepareFailView("Debe agregar un nombre.");
        }

        if(!customer.lastNameIsValid()) {
            customerPresenter.prepareFailView("Debe agregar un apellido.");
        }

        LocalDateTime now = LocalDateTime.now();
        CustomerRequestDsModel customerDsRequest = new CustomerRequestDsModel(
                customer.getNpsv(), customer.getName(), customer.getLastName(),
                customer.getAddress(), customer.getPhone(), customer.getDNI(),
                customer.getEmail(), customer.getCreationDate(), customer.getStatus(), now);

        customerRegisterDsGateway.save(customerDsRequest);

        CustomerResponseModel response = new CustomerResponseModel(customerDsRequest.getNpsv(),
                customerDsRequest.getName(), customerDsRequest.getLastName(), customerDsRequest.getAddress(),
                customerDsRequest.getPhone(), customerDsRequest.getDni(), customerDsRequest.getEmail(),
                customerDsRequest.getCreationDate(), customerDsRequest.getStatus(), now.toString());
        return customerPresenter.prepareSuccessView(response);
    }
}
