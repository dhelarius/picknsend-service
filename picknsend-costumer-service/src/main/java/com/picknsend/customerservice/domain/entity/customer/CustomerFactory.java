package com.picknsend.customerservice.domain.entity.customer;

/**
 * Define el método para la creación de un objeto cliente.
 *
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
public interface CustomerFactory {

    /**
     * Devuelve un objeto cliente basado en sus datos asociados.
     * @param npsv Identificador npsv del cliente.
     * @param name Nombre del cliente.
     * @param lastName Apellido del cliente.
     * @param address Dirección del cliente.
     * @param phone Teléfono del cliente.
     * @param dni Cédula de cliente.
     * @param email Email del cliente.
     * @param creationDate Fecha de creación de registro del cliente.
     * @param status Estado del cliente.
     * @return Costumer
     */
    Customer create(String npsv, String name, String lastName,
                    String address, String phone, String dni, String email,
                    String creationDate, String status);

}
