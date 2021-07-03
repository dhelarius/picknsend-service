package com.picknsend.customerservice.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author dhelarius 2/7/2021
 * picknsend-costumer-service
 */
@Repository
public interface JpaCustomerRepository  extends JpaRepository<CustomerDataMapper, String> {}
