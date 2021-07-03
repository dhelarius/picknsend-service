package com.picknsend.customerservice.adapter.converter;

import com.picknsend.customerservice.adapter.persistence.CustomerDataMapper;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dhelarius 2/7/2021
 * picknsend-costumer-service
 */
public class EntityDtoConverter {

    private final ModelMapper modelMapper;

    public EntityDtoConverter() {
        this.modelMapper = new ModelMapper();
    }

    public CustomerResponseModel convertEntityToDto(CustomerDataMapper customerDataMapper) {
        return modelMapper.map(customerDataMapper, CustomerResponseModel.class);
    }

    public List<CustomerResponseModel> convertEntityToDto(List<CustomerDataMapper> customersDataMapper) {
        return customersDataMapper.stream()
                .map(customerDataMapper -> convertEntityToDto(customerDataMapper))
                .collect(Collectors.toList());
    }
}
