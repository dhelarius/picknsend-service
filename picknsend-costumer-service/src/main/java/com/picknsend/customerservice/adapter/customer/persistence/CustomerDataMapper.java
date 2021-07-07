package com.picknsend.customerservice.adapter.customer.persistence;

import javax.persistence.*;

/**
 * Objeto utilizado para mapear los datos manejados en los registros de
 * la tabla cliente.
 *
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
@Entity
@Table(name = "cliente")
public class CustomerDataMapper {

    @Id
    @Column(name = "Npsv")
    private String npsv;
    @Column(name = "Nombre")
    private String name;
    @Column(name = "Apellido")
    private String lastName;
    @Column(name = "Direccion")
    private String address;
    @Column(name = "Telefono")
    private String phone;
    @Column(name = "Cedula")
    private String dni;
    @Column(name = "Email")
    private String email;
    @Column(name = "Fecha_reg")
    private String creationDate;
    @Column(name = "Estado")
    private String status;

    /**
     * Construye un nuevo objeto de mapeo para la tabla cliente.
     */
    public  CustomerDataMapper() {}

    /**
     * Construye un nuevo objeto de mapeo para la tabla cliente con sus datos asociados.
     * @param npsv Npsv del cliente.
     * @param name Nombre del cliente.
     * @param lastName Apellido del cliente.
     * @param address Dirección del cliente.
     * @param phone Teléfono del cliente.
     * @param dni Cédula del cliente.
     * @param email Email del cliente.
     * @param creationDate Fecha de creación del cliente.
     * @param status Estado del cliente.
     */
    public CustomerDataMapper(String npsv, String name, String lastName,
                              String address, String phone, String dni, String email,
                              String creationDate, String status) {
        super();
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
     * Devuelve el código npsv del cliente.
     * @return String
     */
    public String getNpsv() {
        return npsv;
    }

    /**
     * Recibe el código npsv del cliente y lo asocia al objeto.
     * @param npsv Identificador único del cliente.
     */
    public void setNpsv(String npsv) {
        this.npsv = npsv;
    }

    /**
     * Devuelve el nombre del cliente.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Recibe el nombre del cliente y lo asocia al objeto.
     * @param name Nombre del cliente.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve el apellido del cliente.
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Recibe el apellido del cliente y lo asocia al objeto.
     * @param lastName Apellido del cliente.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Devuelve la dirección del cliente.
     * @return String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Recibe la dirección del cliente y la asocia al objeto.
     * @param address Dirección del cliente.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Devuelve el teléfono del cliente.
     * @return String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Recibe el teléfono del cliente y lo asocia al objeto.
     * @param phone Teléfono del cliente
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Devuelve la cédula del cliente.
     * @return String
     */
    public String getDni() {
        return dni;
    }

    /**
     * Recibe la cédula del cliente y la asocia al objeto.
     * @param dni Cédula del cliente
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve el email del cliente.
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Recibe el email del cliente y lo asocia al objeto.
     * @param email Email del cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve la fecha de creación del cliente.
     * @return String
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * Recibe la fecha de creación del cliente.
     * @param creationDate String
     */
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Devuelve el estado del cliente.
     * @return String
     */
    public String getStatus() {
        return status;
    }

    /**
     * Recibe el estado del cliente.
     * @param status Estado del cliente.
     */
    public void setStatus(String status) {
        this.status = status;
    }
}