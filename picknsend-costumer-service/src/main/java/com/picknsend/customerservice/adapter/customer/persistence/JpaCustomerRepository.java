package com.picknsend.customerservice.adapter.customer.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Define un repositorio jpa para manejar los datos en un objeto CustomerDataMapper.
 *
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
@Repository
public interface JpaCustomerRepository  extends JpaRepository<CustomerDataMapper, String> {}
