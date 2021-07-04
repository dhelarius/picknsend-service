package com.picknsend.customerservice.usecase.gateway;

import com.picknsend.customerservice.usecase.model.CustomerRequestDsModel;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;

import java.util.List;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */

/**
 * Crea un puerto que implementa las operaciones necesarias para gestionar
 * la información de los clientes en la base de datos.
 */
public interface CustomerDsGateway {

    /**
     * Comprueba si un cliente existe basado en el identificador dado.
     * @param npsv Identica a un cliente en la lista de registros.
     * @return Boolean
     */
    boolean existByNpsv(String npsv);

    /**
     * Método de contrato para solicitar de la creación de un cliente.
     * @param request Contiene la información necesaria para registrar un cliente.
     */
    void save(CustomerRequestDsModel request);

    /**
     * Método de contrato para la busqueda de un cliente según su identicador.
     * @param npsv Identificación única para un cliente.
     * @return CustomerResponseModel
     */
    CustomerResponseModel findByNpsv(String npsv);

    /**
     * Método de contrato para la solicitud de una lista de clientes
     * @return List<CustomerResponseModel>
     */
    List<CustomerResponseModel> findAll();

    /**
     * Método de contrato para la solicitud de actualización de un cliente.
     * @param request Solicitud con los datos necesarios para la actualización.
     * @return CustomeRespondeModel
     */
    CustomerResponseModel update(CustomerRequestDsModel request);

    /**
     * Método de contrato para la solicitud de eliminación de un cliente mediante
     * un identifiador dado.
     * @param npsv Identificador único de cliente.
     * @return CustomerResponseModel
     */
    CustomerResponseModel delete(String npsv);
}
