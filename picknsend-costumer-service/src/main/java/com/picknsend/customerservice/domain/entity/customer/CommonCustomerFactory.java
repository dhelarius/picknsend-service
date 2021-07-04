package com.picknsend.customerservice.domain.entity.customer;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */

/**
 * Clase de fábrica para crear un objeto tipo Customer.
 */
public class CommonCustomerFactory implements CustomerFactory{

    /**
     * Método de fábrica que devuelve un objeto cliente basado en sus datos asociados.
     * @param npsv Identificador npsv del cliente.
     * @param name Nombre del cliente.
     * @param lastName Apellido del cliente.
     * @param address Dirección del cliente.
     * @param phone Teléfono del cliente.
     * @param dni Cédula de cliente.
     * @param email Email del cliente.
     * @param creationDate Fecha de creación de registro del cliente.
     * @param status Estado del cliente.
     * @return Customer
     */
    @Override
    public Customer create(String npsv, String name, String lastName, String address, String phone, String dni, String email, String creationDate, String status) {
        return new CommonCustomer(npsv, name, lastName, address, phone, dni,
                email, creationDate, status);
    }
}
