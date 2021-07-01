package com.picknsend.customerservice.usecase.interactor;

import com.picknsend.customerservice.usecase.gateway.CustomerFindAllDsGateway;
import com.picknsend.customerservice.usecase.gateway.CustomerOutputBoundary;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import com.picknsend.customerservice.usecase.presenter.CustomerPresenter;

import java.util.List;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
public class CustomersFinderInteractor implements CustomerOutputBoundary {

    private final CustomerFindAllDsGateway customerFindAllDsGateway;
    private final CustomerPresenter customerPresenter;

    public CustomersFinderInteractor(CustomerFindAllDsGateway customerFindAllDsGateway,
                                     CustomerPresenter customerPresenter) {
        this.customerFindAllDsGateway = customerFindAllDsGateway;
        this.customerPresenter = customerPresenter;
    }

    @Override
    public List<CustomerResponseModel> read() {
        var response = customerFindAllDsGateway.findAdll();
        return customerPresenter.prepareSuccessView(response);
    }
}
