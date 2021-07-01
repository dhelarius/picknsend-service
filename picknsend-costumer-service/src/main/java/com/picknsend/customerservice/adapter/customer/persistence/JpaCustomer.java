package com.picknsend.customerservice.adapter.customer.persistence;

import com.picknsend.customerservice.adapter.customer.converter.EntityDtoConverter;
import com.picknsend.customerservice.usecase.gateway.CustomerFindAllDsGateway;
import com.picknsend.customerservice.usecase.gateway.CustomerRegisterDsGateway;
import com.picknsend.customerservice.usecase.model.CustomerDsRequestModel;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;

import java.util.List;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
public class JpaCustomer implements CustomerRegisterDsGateway,
        CustomerFindAllDsGateway {

    private final JpaCustomerRepository repository;
    private final EntityDtoConverter converter;

    public JpaCustomer(JpaCustomerRepository repository,
                       EntityDtoConverter converte) {
        this.repository = repository;
        this.converter = converte;
    }

    @Override
    public boolean existByNpsv(String npsv) {
        return repository.existsById(npsv);
    }

    @Override
    public void save(CustomerDsRequestModel request) {
        CustomerDataMapper dataMapper = new CustomerDataMapper(request.getNpsv(), request.getName(),
                request.getLastName(), request.getAddress(), request.getPhone(), request.getDni(),
                request.getEmail(), request.getCreationDate(), request.getStatus());
        repository.save(dataMapper);
    }

    @Override
    public List<CustomerResponseModel> findAdll() {
        return converter.convertEntityToDto(repository.findAll());
    }
}
