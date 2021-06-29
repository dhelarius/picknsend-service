package com.picknsend.costumerservice.adapter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
@Service
public class CustomerService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> findAllCustomer() {
        return jdbcTemplate.queryForList("select * from cliente");
    }
}
