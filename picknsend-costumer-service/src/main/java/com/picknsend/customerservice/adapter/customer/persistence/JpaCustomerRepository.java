package com.picknsend.customerservice.adapter.customer.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Define un repositorio jpa para manejar los datos en un objeto CustomerDataMapper.
 *
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
@Repository
public interface JpaCustomerRepository  extends JpaRepository<CustomerDataMapper, String> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE CustomerDataMapper u SET u.status = 'I' WHERE u.npsv = ?1")
    void inactivate(String npsv);
}
