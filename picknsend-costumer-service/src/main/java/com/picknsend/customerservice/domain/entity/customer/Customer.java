package com.picknsend.customerservice.domain.entity.customer;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
public interface Customer {

    String getNpsv();

    String getName();

    String getLastName();

    String getAddress();

    String getPhone();

    String getDNI();

    String getEmail();

    String getCreationDate();

    String getStatus();

    boolean npsvIsValid();

    boolean nameIsValid();

    boolean lastNameIsValid();
}

