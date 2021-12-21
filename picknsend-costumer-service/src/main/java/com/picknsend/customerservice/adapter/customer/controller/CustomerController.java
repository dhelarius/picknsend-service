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
 * Controlador de springboot que implementa los endpoints de ejecución de solicitudes
 * web de la información de clientes.
 *
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
@Api
@RestController
@RequestMapping(value = CustomerControllerPaths.BASE_PATH)
public class CustomerController {

    private final CustomerInputBoundary customerInputBoundary;
    private final CustomerOutputBoundary customerOutputBoundary;
    private final CustomersOutputBoundary customersOutputBoundary;
    private final CustomerUpdateBoundary customerUpdateBoundary;
    private final CustomerDeleteBoundary customerDeleteBoundary;
    private final CustomerInactivateBoundary customerInactivateBoundary;

    /**
     * Crea un nuevo controlador de cliente con sus limites de entrada y salida asociados.
     * @param customerInputBoundary Define la creación de un cliente.
     * @param customerOutputBoundary Define la obtención de datos de un cliente.
     * @param customersOutputBoundary Define la obtención de datos de una lista de clientes.
     * @param customerUpdateBoundary Define la actualización de datos de un cliente.
     * @param customerDeleteBoundary Define la eliminación de un cliente.
     * @param customerInactivateBoundary Define la iinativación de un cliente.
     */
    public CustomerController(CustomerInputBoundary customerInputBoundary,
                              CustomerOutputBoundary customerOutputBoundary,
                              CustomersOutputBoundary customersOutputBoundary,
                              CustomerUpdateBoundary customerUpdateBoundary,
                              CustomerDeleteBoundary customerDeleteBoundary,
                              CustomerInactivateBoundary customerInactivateBoundary) {
        this.customerInputBoundary = customerInputBoundary;
        this.customerOutputBoundary = customerOutputBoundary;
        this.customerUpdateBoundary = customerUpdateBoundary;
        this.customersOutputBoundary = customersOutputBoundary;
        this.customerDeleteBoundary = customerDeleteBoundary;
        this.customerInactivateBoundary = customerInactivateBoundary;
    }

    /**
     * Devuelve un objeto Json con los datos del cliente creado.
     * @param request Solicitud definida en un objeto Json.
     * @return {@code ResponseEntity<CustomerResponseModel> }
     */
    @ApiOperation(value = "Crea un nuevo cliente",
            notes = "Esta operacion crea un nuevo cliente a partir de un objeto de solicitud")
    @PostMapping(value = CustomerControllerPaths.CREATE)
    public ResponseEntity<CustomerResponseModel> create(@RequestBody CustomerRequestModel request) {
        var response = customerInputBoundary.create(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Devuelve un objeto Json con los datos de un cliente basado en su npsv asociado.
     * @param npsv Identificador único del cliente.
     * @return {@code ResponseEntity<CustomerResponseModel> }
     */
    @ApiOperation(value = "Devuelve un cliente basado en su npsv",
            notes = "Esta operacion devuelve un cliente basado en su npsv")
    @GetMapping(value = CustomerControllerPaths.FIND_CUSTOMER)
    public ResponseEntity<CustomerResponseModel> findByNpsv(@PathVariable String npsv) {
        var response = customerOutputBoundary.findByNpsv(npsv);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Devuelve un objeto Json con la lista de todos los clientes existentes.
     * @return {@code ResponseEntity<List<CustomerResponseModel>> }
     */
    @ApiOperation(value = "Devuelve una lista de clientes",
            notes = "Esta operacion devuelve una lista de clientes")
    @GetMapping(value = CustomerControllerPaths.FIND_CUSTOMERS)
    public ResponseEntity<List<CustomerResponseModel>> findAll() {
        var response = customersOutputBoundary.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Devuelve un objeto Json con los datos actualizados de un cliente basado en su npsv.
     * @param request Solicitud definida en un objeto Json.
     * @return {@code ResponseEntity<CustomerResponseModel> }
     */
    @ApiOperation(value = "Actualiza un cliente",
            notes = "Esta operacion actualiza un cliente existente")
    @PutMapping(value = CustomerControllerPaths.UPDATE)
    public ResponseEntity<CustomerResponseModel> update(@RequestBody CustomerRequestModel request) {
        var response = customerUpdateBoundary.update(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Elimina un cliente basado en su npsv asociado.
     * @param npsv Identificador único de cliente.
     * @return {@code ResponseEntity<CustomerResponseModel> }
     */
    @ApiOperation(value = "Elimina un cliente",
            notes = "Esta operacion elimina un cliente basado en su npsv")
    @DeleteMapping(value = CustomerControllerPaths.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable String npsv) {
        var response = customerDeleteBoundary.delete(npsv);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    /**
     * Inactiva un cliente basado en su npsv asociado.
     * @param npsv Identificador único de cliente.
     * @return {@code ResponseEntity<CustomerResponseModel> }
     */
    @ApiOperation(value = "Inactiva un cliente",
            notes = "Esta operacion inactiva un cliente basado en su npsv")
    @PutMapping(value = CustomerControllerPaths.INACTIVATE)
    public ResponseEntity<CustomerResponseModel> inactivate(@PathVariable String npsv) {
        var response = customerInactivateBoundary.inactivate(npsv);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
