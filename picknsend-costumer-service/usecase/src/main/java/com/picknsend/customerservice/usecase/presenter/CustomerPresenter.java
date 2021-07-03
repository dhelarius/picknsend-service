package com.picknsend.customerservice.usecase.presenter;

import com.picknsend.customerservice.usecase.model.CustomerResponseModel;

import java.util.List;

/**
 * @author dhelarius 2/7/2021
 * picknsend-costumer-service
 */
public interface CustomerPresenter {

    CustomerResponseModel prepareSuccessView(CustomerResponseModel response);

    List<CustomerResponseModel> prepareSuccessView(List<CustomerResponseModel> responses);

    CustomerResponseModel prepareFailView(String error);
}
