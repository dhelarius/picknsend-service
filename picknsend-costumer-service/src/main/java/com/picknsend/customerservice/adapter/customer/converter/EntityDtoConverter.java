package com.picknsend.customerservice.adapter.customer.converter;

import com.picknsend.customerservice.adapter.customer.persistence.CustomerDataMapper;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Conversor para mapear objetos CustomerDataMapper en objetos de respuesta.
 *
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
public class EntityDtoConverter {

    private final ModelMapper modelMapper;

    /**
     * Crea un nuevo conversor.
     */
    public EntityDtoConverter() {
        this.modelMapper = new ModelMapper();
    }

    /**
     * Devuelve un objeto CustomerReponseModel dado un objeto CustomerDataMapper
     * @param customerDataMapper Mapeador jpa de datos de la tabla cliente.
     * @return CustomerResponseMdel
     */
    public CustomerResponseModel convertEntityToDto(CustomerDataMapper customerDataMapper) {
        return modelMapper.map(customerDataMapper, CustomerResponseModel.class);
    }

    /**
     * Devuelve una lista de objetos CustomerReponseModel dada una lista de objetos
     * CustomerDataMapper
     * @param customersDataMapper Lista de objetos CustomerDataMapper
     * @return {@code List<CustomerResponseModel>}
     */
    public List<CustomerResponseModel> convertEntityToDto(List<CustomerDataMapper> customersDataMapper) {
        return customersDataMapper.stream()
                .map(customerDataMapper -> convertEntityToDto(customerDataMapper))
                .collect(Collectors.toList());
    }
}
