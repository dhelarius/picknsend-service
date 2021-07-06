package com.picknsend.customerservice.adapter.customer.controller;

import com.picknsend.customerservice.usecase.gateway.*;
import com.picknsend.customerservice.usecase.model.CustomerRequestModel;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */

/**
 * Controlador de springboot que implementa los endpoints de ejecución de solicitudes
 * web de la información de clientes.
 */
@Api
@RestController
public class CustomerController {

    private final CustomerInputBoundary customerInputBoundary;
    private final CustomerOutputBoundary customerOutputBoundary;
    private final CustomersOutputBoundary customersOutputBoundary;
    private final CustomerUpdateBoundary customerUpdateBoundary;
    private final CustomerDeleteBoundary customerDeleteBoundary;

    /**
     * Crea un nuevo controlador de cliente con sus limites de entrada y salida asociados.
     * @param customerInputBoundary Define la creación de un cliente.
     * @param customerOutputBoundary Define la obtención de datos de un cliente.
     * @param customersOutputBoundary Define la obtención de datos de una lista de clientes.
     * @param customerUpdateBoundary Define la actualización de datos de un cliente.
     * @param customerDeleteBoundary Defina la eliminación de un cliente.
     */
    public CustomerController(CustomerInputBoundary customerInputBoundary,
                              CustomerOutputBoundary customerOutputBoundary,
                              CustomersOutputBoundary customersOutputBoundary,
                              CustomerUpdateBoundary customerUpdateBoundary,
                              CustomerDeleteBoundary customerDeleteBoundary) {
        this.customerInputBoundary = customerInputBoundary;
        this.customerOutputBoundary = customerOutputBoundary;
        this.customerUpdateBoundary = customerUpdateBoundary;
        this.customersOutputBoundary = customersOutputBoundary;
        this.customerDeleteBoundary = customerDeleteBoundary;
    }

    @ApiOperation(value = "Crea un nuevo cliente",
            notes = "Esta operacion crea un nuevo cliente a partir de un objeto de solicitud")
    /**
     * Devuelve un objeto Json con los datos del cliente creado.
     * @param request Solicitud definida en un objeto Json.
     * @return {@code ResponseEntity<CustomerResponseModel> }
     */
    @PostMapping(value = "/customer/create")
    public ResponseEntity<CustomerResponseModel> create(@RequestBody CustomerRequestModel request) {
        var response = customerInputBoundary.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Devuelve un cliente basado en su npsv",
            notes = "Esta operacion devuelve un cliente basado en su npsv")
    /**
     * Devuelve un objeto Json con los datos de un cliente basado en su npsv asociado.
     * @param npsv Identificador único del cliente.
     * @return {@code ResponseEntity<CustomerResponseModel> }
     */
    @GetMapping(value = "/customer/{npsv}")
    public ResponseEntity<CustomerResponseModel> findByNpsv(@PathVariable String npsv) {
        var response = customerOutputBoundary.findByNpsv(npsv);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Devuelve una lista de clientes",
            notes = "Esta operacion devuelve una lista de clientes")
    /**
     * Devuelve un objeto Json con la lista de todos los clientes existentes.
     * @return {@code ResponseEntity<List<CustomerResponseModel>> }
     */
    @GetMapping(value = "/customer")
    public ResponseEntity<List<CustomerResponseModel>> findAll() {
        var response = customersOutputBoundary.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Actualiza un cliente",
            notes = "Esta operacion actualiza un cliente existente")
    /**
     * Devuelve un objeto Json con los datos actualizados de un cliente basado en su npsv.
     * @param request Solicitud definida en un objeto Json.
     * @return {@code ResponseEntity<CustomerResponseModel> }
     */
    @PutMapping(value = "/customer")
    public ResponseEntity<CustomerResponseModel> update(@RequestBody CustomerRequestModel request) {
        var response = customerUpdateBoundary.update(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "Elimina un cliente",
            notes = "Esta operacion elimina un cliente basado en su npsv")
    /**
     * Elimina un cliente basado en su npsv asociado.
     * @param npsv Identificador único de cliente.
     * @return {@code ResponseEntity<CustomerResponseModel> }
     */
    @DeleteMapping(value = "/customer/{npsv}")
    public ResponseEntity<CustomerResponseModel> delete(@PathVariable String npsv) {
        var response = customerDeleteBoundary.delete(npsv);
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}
