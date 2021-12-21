package com.picknsend.customerservice.adapter.customer.persistence;

import com.picknsend.customerservice.adapter.customer.converter.EntityDtoConverter;
import com.picknsend.customerservice.adapter.customer.dao.CustomerDao;
import com.picknsend.customerservice.usecase.gateway.CustomerDsGateway;
import com.picknsend.customerservice.usecase.model.CustomerRequestDsModel;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Clase adaptador jpa que implementa los procesos definidos por
 * los casos de uso para realizar solicitudes en la base de datos.
 *
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
public class JpaCustomer implements CustomerDsGateway {

    private final JpaCustomerRepository repository;
    private final EntityDtoConverter converter;
    private final JdbcTemplate jdbcTemplate;
    private final CustomerDao customerDao;

    /**
     * Construye un nuevo objeto jpa para ejecutar las solicitudes en la base
     * de datos sobre un objeto cliente.
     * @param repository Realiza operaciones en los dato de un objeto CustomerDataMapper
     *                   asociado a una entidad cliente en la base de datos.
     * @param converter Mapea un tipo de objeto en otro.
     * @param jdbcTemplate Plantilla para ejecutar solicitudes en la base de datos
     *                     mediante JDBC.
     * @param customerDao Objeto de acceso a datos de cliente.
     */
    public JpaCustomer(JpaCustomerRepository repository, EntityDtoConverter converter,
                       JdbcTemplate jdbcTemplate, CustomerDao customerDao) {
        this.repository = repository;
        this.converter = converter;
        this.jdbcTemplate = jdbcTemplate;
        this.customerDao = customerDao;
    }

    /**
     * Valida si un cliente existe según el npsv dado.
     * @param npsv Identica a un cliente en la lista de registros.
     * @return boolean
     */
    @Override
    public boolean existByNpsv(String npsv) {
        return repository.existsById(npsv);
    }

    /**
     * Guarda un nuevo cliente en la base de datos.
     * @param request Contiene la información necesaria para registrar un cliente.
     */
    @Override
    public void save(CustomerRequestDsModel request) {
        CustomerDataMapper dataMapper = new CustomerDataMapper(request.getNpsv(), request.getName(),
                request.getLastName(), request.getAddress(), request.getPhone(), request.getDni(),
                request.getEmail(), request.getCreationDate(), request.getStatus());
        repository.save(dataMapper);
    }

    /**
     * Devuelve una solicitud satisfactoria de un cliente con sus datos asociados.
     * @param npsv Identificación única para un cliente.
     * @return CustomerResponseModel
     */
    @Override
    public CustomerResponseModel findByNpsv(String npsv) {
        CustomerDataMapper customerDataMapper = new CustomerDataMapper();
        if(repository.findById(npsv).isPresent()) {
            customerDataMapper = repository.getById(npsv);
        }
        return converter.convertEntityToDto(customerDataMapper);
    }

    /**
     * Devuelve una respuesta satisfactoria de una lista de clientes con sus datos
     * asociados.
     * @return {@code List<CustomerResponseModel>}
     */
    @Override
    public List<CustomerResponseModel> findAll() {
        return converter.convertEntityToDto(repository.findAll());
    }

    /**
     * Devuelve una respuesta satisfactoria con los datos actualizados de un cliente.
     * @param request Solicitud con los datos necesarios para la actualización.
     * @return CustomerResponseModel
     */
    @Override
    public CustomerResponseModel update(CustomerRequestDsModel request) {
        customerDao.update(jdbcTemplate, request);
        var customerDataMapper = repository.getById(request.getNpsv());
        return converter.convertEntityToDto(customerDataMapper);
    }

    /**
     * Elimina un cliente basandose en su npsv asociado.
     * @param npsv Identificador único de cliente.
     * @return CustomerResponseModel
     */
    @Override
    public CustomerResponseModel delete(String npsv) {
        repository.deleteById(npsv);
        return null;
    }

    @Override
    public CustomerResponseModel inactivate(String npsv) {
        repository.inactivate(npsv);
        var customerDataMapper = repository.getById(npsv);
        return converter.convertEntityToDto(customerDataMapper);
    }
}
