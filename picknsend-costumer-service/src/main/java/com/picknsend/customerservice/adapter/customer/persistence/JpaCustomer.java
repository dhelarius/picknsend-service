package com.picknsend.customerservice.adapter.customer.persistence;

import com.picknsend.customerservice.adapter.customer.converter.EntityDtoConverter;
import com.picknsend.customerservice.adapter.customer.dao.CustomerDao;
import com.picknsend.customerservice.usecase.gateway.CustomerDsGateway;
import com.picknsend.customerservice.usecase.model.CustomerRequestDsModel;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
public class JpaCustomer implements CustomerDsGateway {

    private final JpaCustomerRepository repository;
    private final EntityDtoConverter converter;
    private final JdbcTemplate jdbcTemplate;
    private final CustomerDao customerDao;

    public JpaCustomer(JpaCustomerRepository repository, EntityDtoConverter converter,
                       JdbcTemplate jdbcTemplate, CustomerDao customerDao) {
        this.repository = repository;
        this.converter = converter;
        this.jdbcTemplate = jdbcTemplate;
        this.customerDao = customerDao;
    }

    @Override
    public boolean existByNpsv(String npsv) {
        return repository.existsById(npsv);
    }

    @Override
    public void save(CustomerRequestDsModel request) {
        CustomerDataMapper dataMapper = new CustomerDataMapper(request.getNpsv(), request.getName(),
                request.getLastName(), request.getAddress(), request.getPhone(), request.getDni(),
                request.getEmail(), request.getCreationDate(), request.getStatus());
        repository.save(dataMapper);
    }

    @Override
    public CustomerResponseModel findByNpsv(String npsv) {
        CustomerDataMapper customerDataMapper = new CustomerDataMapper();
        if(repository.findById(npsv).isPresent()) {
            customerDataMapper = repository.getById(npsv);
        }
        return converter.convertEntityToDto(customerDataMapper);
    }

    @Override
    public List<CustomerResponseModel> findAll() {
        return converter.convertEntityToDto(repository.findAll());
    }

    @Override
    public CustomerResponseModel update(CustomerRequestDsModel request) {
        customerDao.update(jdbcTemplate, request);
        var customerDataMapper = repository.getById(request.getNpsv());
        return converter.convertEntityToDto(customerDataMapper);
    }

    @Override
    public CustomerResponseModel delete(String npsv) {
        repository.deleteById(npsv);
        return null;
    }
}
