package com.picknsend.customerservice.usecase.model;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
public class CustomerRequestModel {

    private String npsv;
    private String name;
    private String lastName;
    private String address;
    private String phone;
    private String dni;
    private String email;
    private String creationDate;
    private String status;

    public CustomerRequestModel() {
        super();
    }

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

    public String getNpsv() {
        return npsv;
    }

    public void setNpsv(String npsv) {
        this.npsv = npsv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}