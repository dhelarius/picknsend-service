import com.picknsend.customerservice.usecase.gateway.CustomerRegisterDsGateway;
import com.picknsend.customerservice.usecase.interactor.CustomerRegisterInteractor;
import com.picknsend.customerservice.usecase.model.CustomerRequestDsModel;
import com.picknsend.customerservice.usecase.model.CustomerRequestModel;
import com.picknsend.customerservice.usecase.model.CustomerResponseModel;
import com.picknsend.customerservice.usecase.presenter.CustomerPresenter;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

/**
 * @author dhelarius 2/7/2021
 * picknsend-costumer-service
 */
public class CustomerRegisterInteractorUnitTest {

    private CustomerRegisterDsGateway customerRegisterDsGateway;
    private CustomerRegisterInteractor customerRegisterInteractor;
    private CustomerPresenter customerPresenter;

    @Test
    void givenCustomerDate_whenCreate_thenSaveSuccessView() {
        given(customerRegisterDsGateway.existByNpsv("11096"))
                .willReturn(true);

        customerRegisterInteractor.create(new CustomerRequestModel("11097",
                "John", "Doe", "La Vega", "809-482-4284", "047-4268482-2", "jdoe@gmail.com",
                "27/06/2021", "A"));

        then(customerRegisterDsGateway).should()
                .save(new CustomerRequestDsModel("11097", "John", "Doe", "La vega",
                        "809-486-4815", "047-1516518-1", "jdoe@gmail.com",
                        "27/06/2021", "A", now()));
        then(customerPresenter).should()
                .prepareSuccessView(new CustomerResponseModel("11097", "John", "Doe", "La Vega",
                        "809-486-4815", "047-1516518-1", "jdoe@gmail.com", "27/06/2021", "A",
                        "27/06/2021"));
    }

    private LocalDateTime now() {
        return LocalDateTime.now();
    }
}
