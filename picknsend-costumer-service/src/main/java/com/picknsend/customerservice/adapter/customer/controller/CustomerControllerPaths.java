package com.picknsend.customerservice.adapter.customer.controller;

/**
 * Cadenas constantes para los endpoints del controlador
 *
 * @author dhelarius 7/7/2021
 * picknsend-costumer-service
 */
public class CustomerControllerPaths {

    public static final String BASE_PATH = "/api/v1";

    public static final String CREATE = "/customer/create";
    public static final String FIND_CUSTOMER = "/customer/{npsv}";
    public static final String FIND_CUSTOMERS = "/customer";
    public static final String UPDATE = "/customer";
    public static final String DELETE = "/customer/{npsv}";
    public static final String INACTIVATE = "/customer/inactivate/{npsv}";
}
