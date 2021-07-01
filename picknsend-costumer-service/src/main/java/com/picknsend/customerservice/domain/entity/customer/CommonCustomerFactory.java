package com.picknsend.customerservice.domain.entity.customer;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
public class CommonCustomerFactory implements CustomerFactory{

    @Override
    public Customer create(String npsv, String name, String lastName, String address, String phone, String dni, String email, String creationDate, String status) {
        return new CommonCustomer(npsv, name, lastName, address, phone, dni,
                email, creationDate, status);
    }
}
