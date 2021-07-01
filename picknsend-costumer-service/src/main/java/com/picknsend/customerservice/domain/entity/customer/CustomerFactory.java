package com.picknsend.customerservice.domain.entity.customer;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
public interface CustomerFactory {

    Customer create(String npsv, String name, String lastName,
                    String address, String phone, String dni, String email,
                    String creationDate, String status);

}
