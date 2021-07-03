package com.picknsend.customerservice.usecase.interactor;

import com.picknsend.customerservice.usecase.gateway.CustomersFinderDsGateway;
import com.picknsend.customerservice.usecase.gateway.CustomerOutputBoundary;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import com.picknsend.customerservice.usecase.presenter.CustomerPresenter;

import java.util.List;

/**
 * @author dhelarius 2/7/2021
 * picknsend-costumer-service
 */
public class CustomersFinderInteractor implements CustomerOutputBoundary {

    private CustomersFinderDsGateway customersFinderDsGateway;
    private CustomerPresenter customerPresenter;

    public CustomersFinderInteractor() {}

    public CustomersFinderInteractor(CustomersFinderDsGateway customersFinderDsGateway,
                                     CustomerPresenter customerPresenter) {
        this.customersFinderDsGateway = customersFinderDsGateway;
        this.customerPresenter = customerPresenter;
    }

    @Override
    public List<CustomerResponseModel> findAll() {
        var response = customersFinderDsGateway.findAll();
        return customerPresenter.prepareSuccessView(response);
    }
}

