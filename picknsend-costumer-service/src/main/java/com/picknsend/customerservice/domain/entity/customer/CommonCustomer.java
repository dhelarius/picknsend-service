package com.picknsend.customerservice.domain.entity.customer;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */

/**
 * Clase para el procesamiento de datos de un cliente.
 */
public class CommonCustomer implements Customer{

    private String npsv;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String dni;
    private String email;
    private String creationDate;
    private String status;

    /**
     * Construye un nuevo cliente.
     */
    public CommonCustomer() {}

    /**
     * Construye un nuevo cliente con sus datos asociados.
     * @param npsv Identificador único del cliente.
     * @param name Nombre del cliente.
     * @param lastName Apellido del cliente.
     * @param address Dirección del cliente.
     * @param phone Télefono del cliente.
     * @param dni Cédula del cliente.
     * @param email Email del cliente.
     * @param creationDate Fecha de creación de registro del cliente.
     * @param status Estado del cliente.
     */
    public CommonCustomer(String npsv, String name, String lastName,
                          String address, String phone, String dni, String email,
                          String creationDate, String status) {
        this.npsv = npsv;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.dni = dni;
        this.email = email;
        this.creationDate = creationDate;
        this.status = status;
    }

    /**
     * Devuelve el identificador npsv asociado del cliente.
     * @return String
     */
    @Override
    public String getNpsv() {
        return npsv;
    }

    /**
     * Devuelve el nombre del cliente.
     * @return String
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Devuelve el apellido del cliente.
     * @return String
     */
    @Override
    public String getLastName() {
        return lastName;
    }

    /**
     * Devuelve la dirección del cliente.
     * @return String
     */
    @Override
    public String getAddress() {
        return address;
    }

    /**
     * Devuelve el teléfono del cliente.
     * @return String
     */
    @Override
    public String getPhone() {
        return phone;
    }

    /**
     * Devuelve la cédula del cliente.
     * @return String
     */
    @Override
    public String getDNI() {
        return dni;
    }

    /**
     * Devuelve el email del cliente.
     * @return String
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * Devuelve la fecha de creación de registro de un cliente.
     * @return String
     */
    @Override
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * Devuelve el estado de un cliente.
     * @return String
     */
    @Override
    public String getStatus() {
        return status;
    }

    /**
     * Notifica si el identificador pnsv del cliente es válido.
     * @return boolean
     */
    @Override
    public boolean npsvIsValid() {
        return !npsv.isBlank() && !npsv.isEmpty();
    }

    /**
     * Notifica si el nombre del cliente es válido.
     * @return boolean
     */
    @Override
    public boolean nameIsValid() {
        return !name.isBlank() && !name.isEmpty();
    }

    /**
     * Notifica si el apellido del cliente es válido.
     * @return String
     */
    @Override
    public boolean lastNameIsValid() {
        return !lastName.isBlank() && !lastName.isEmpty();
    }
}

