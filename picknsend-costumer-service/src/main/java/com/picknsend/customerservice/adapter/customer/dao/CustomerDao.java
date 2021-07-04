package com.picknsend.customerservice.adapter.customer.dao;

import com.picknsend.customerservice.usecase.model.CustomerRequestDsModel;
import com.picknsend.customerservice.util.StringUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author dhelarius 3/7/2021
 * picknsend-costumer-service
 */
public class CustomerDao {

    public CustomerDao() {}

    public void update(JdbcTemplate jdbcTemplate, CustomerRequestDsModel request) {
        var npsv = StringUtil.addQuotes(request.getNpsv());
        var name = StringUtil.addQuotes(request.getName());
        var lastName = StringUtil.addQuotes(request.getLastName());
        var address = StringUtil.addQuotes(request.getAddress());
        var phone = StringUtil.addQuotes(request.getPhone());
        var dni = StringUtil.addQuotes(request.getDni());
        var email = StringUtil.addQuotes(request.getEmail());
        var creationDate = StringUtil.addQuotes(request.getCreationDate());
        var status = StringUtil.addQuotes(request.getStatus());

        try {
            jdbcTemplate.update("UPDATE cliente SET Npsv=" + npsv + ",Nombre=" + name +
                    ",Apellido=" + lastName + ",Direccion=" + address + ",Telefono=" + phone +
                    ",Cedula=" + dni + ",Email=" + email + ",Fecha_reg=" + creationDate +
                    ",Estado=" + status + "WHERE Npsv=" + npsv);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }
}
