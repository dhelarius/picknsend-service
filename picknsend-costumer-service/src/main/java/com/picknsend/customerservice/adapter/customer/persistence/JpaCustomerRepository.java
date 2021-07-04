package com.picknsend.customerservice.adapter.customer.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
@Repository
public interface JpaCustomerRepository  extends JpaRepository<CustomerDataMapper, String> {

    /*@Query("SELECT * FROM cliente WHERE LOWER(nombre) = LOWER(:name)")
    CustomerDataMapper find(@Param("name") String name);*/
}
