package com.picknsend.customerservice.domain.entity.customer;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */

/**
 * Define los métodos de obtención de datos de un cliente.
 */
public interface Customer {

    /**
     * Devuelve el identificador npsv de un cliente.
     * @return String
     */
    String getNpsv();

    /**
     * Devuelve el nombre del cliente.
     * @return String
     */
    String getName();

    /**
     * Devuelve el apellido del cliente.
     * @return String
     */
    String getLastName();

    /**
     * Devuelve la dirección del cliente.
     * @return String
     */
    String getAddress();

    /**
     * Devuelve el teléfono del cliente.
     * @return String
     */
    String getPhone();

    /**
     * Devuelve la cédula del cliente.
     * @return String
     */
    String getDNI();

    /**
     * Devuelve el email del cliente.
     * @return String
     */
    String getEmail();

    /**
     * Devuelve la fecha de creación de registro del cliente.
     * @return String
     */
    String getCreationDate();

    /**
     * Devuelve el estado del cliente.
     * @return String
     */
    String getStatus();

    /**
     * Notifica si el npsv del cliente es válido.
     * @return boolean
     */
    boolean npsvIsValid();

    /**
     * Notifica si el nombre del cliente es válido.
     * @return boolean
     */
    boolean nameIsValid();

    /**
     * Notifica si el apellido del cliente es válido.
     * @return boolean
     */
    boolean lastNameIsValid();
}
