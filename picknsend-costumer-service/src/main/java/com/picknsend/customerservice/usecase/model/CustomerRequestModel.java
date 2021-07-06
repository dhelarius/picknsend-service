package com.picknsend.customerservice.usecase.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */

@ApiModel(description = "Clase que representa un cliente a procesar")
/**
 * Objeto de transferencia para realizar solicitudes desde los puntos de
 * entrada del servicio.
 */
public class CustomerRequestModel {

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Npsv de cliente", example = "4562", required = true)
    private String npsv;
    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Nombre de cliente", example = "John", required = true)
    private String name;
    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Apellido de cliente", example = "Doe", required = true)
    private String lastName;
    @ApiModelProperty(notes = "Dirección del cliente", example = "La Vega")
    private String address;
    @ApiModelProperty(notes = "Teléfono del cliente", example = "809-482-4694")
    private String phone;
    @ApiModelProperty(notes = "Cédula del cliente", example = "047-1156115-1")
    private String dni;
    @ApiModelProperty(notes = "Correo del cliente", example = "jdoe@gmail.com")
    private String email;
    @ApiModelProperty(notes = "Fecha de creación del cliente", example = "05/07/2021")
    private String creationDate;
    @ApiModelProperty(notes = "Estado del cliente", example = "A")
    private String status;

    /**
     * Construye un nuevo objeto de transferencia para realizar solicitudes.
     */
    public CustomerRequestModel() {
        super();
    }

    /**
     * Construye un nuevo objeto de transferencia con sus datos asociados
     * para realizar solicitudes.
     * @param npsv Identificador único del cliente.
     * @param name Nombre del cliente.
     * @param lastName Apellido del cliente.
     * @param address Dirección del cliente.
     * @param phone Teléfono del cliente.
     * @param dni Cédula del cliente.
     * @param email Email del cliente.
     * @param creationDate Fecha de creación de registro del cliente.
     * @param status Estado del cliente.
     */
    public CustomerRequestModel(String npsv, String name, String lastName, String address,
                           String phone, String dni, String email, String creationDate,
                           String status) {
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
     * Devuelve la dirección del cliente
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