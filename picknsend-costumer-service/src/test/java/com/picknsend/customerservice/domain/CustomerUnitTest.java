package com.picknsend.customerservice.domain;

import com.picknsend.customerservice.domain.entity.customer.CommonCustomer;
import com.picknsend.customerservice.domain.entity.customer.Customer;
import org.junit.jupiter.api.Test;

/**
 * @author dhelarius 29/6/2021
 * picknsend-costumer-service
 */
public class CustomerUnitTest {

    @Test
    void givenVoidNpsv_whenNpsvIsNotValid_thenIsFalse() {
        Customer costumer = new CommonCustomer("", "Jorge", "Martinez",
                "La Vega", "809-458-4792", "047-1566264-4",
                "jmartinez@gmail.com", "27/06/2021", "A");

        assert(!costumer.npsvIsValid());
    }

    @Test
    void givenVoidName_whenNameIsNotValid_thenIsFalse() {
        Customer costumer = new CommonCustomer("42554", "", "Martinez",
                "La Vega", "809-458-4792", "047-1566264-4",
                "jmartinez@gmail.com", "27/06/2021", "A");

        assert(!costumer.nameIsValid());
    }

    @Test
    void givenVoidLastName_whenLastNameIsNotValid_thenIsFalse() {
        Customer costumer = new CommonCustomer("42554", "Jorge", "",
                "La Vega", "809-458-4792", "047-1566264-4",
                "jmartinez@gmail.com", "27/06/2021", "A");

        assert(!costumer.lastNameIsValid());
    }
}
