package com.picknsend.customerservice.adapter;

import com.picknsend.customerservice.adapter.customer.formatter.CustomerResponseFormatter;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author dhelarius 6/7/2021
 * picknsend-costumer-service
 */
public class CustomerResponseFormatterUnitTest {

    CustomerResponseFormatter customerResponseFormatter = new CustomerResponseFormatter();

    @Test
    void givenDateAnd3HourTime_whenPrepareSuccessView_thenReturnOnly3HourTime() {
        CustomerResponseModel modelResponse = new CustomerResponseModel("9913", "John", "Doe",
                "Santiago", "809-482-4284", "047-4268482-2", "jdoe@gmail.com",
                "06/07/2021", "A");
        CustomerResponseModel formattedResponse = customerResponseFormatter.prepareSuccessView(modelResponse);

        assertThat(formattedResponse.getCreationDate()).isEqualTo("06/07/2021");
    }

    @Test
    void whenPrepareFailView_thenThrowHttpConflictException() {
        assertThatThrownBy(() -> customerResponseFormatter.prepareFailView("Invalid password"))
                .isInstanceOf(ResponseStatusException.class);
    }
}
