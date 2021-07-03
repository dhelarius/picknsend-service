package com.picknsend.customerservice.domain;

/**
 * @author dhelarius 1/7/2021
 * picknsend-costumer-service
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

    public CommonCustomer() {}

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

    @Override
    public String getNpsv() {
        return npsv;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getDNI() {
        return dni;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getCreationDate() {
        return creationDate;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public boolean npsvIsValid() {
        return !npsv.isBlank() && !npsv.isEmpty();
    }

    @Override
    public boolean nameIsValid() {
        return !name.isBlank() && !name.isEmpty();
    }

    @Override
    public boolean lastNameIsValid() {
        return !lastName.isBlank() && !lastName.isEmpty();
    }
}